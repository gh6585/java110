package bitcamp.java110.cms;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@ComponentScan(basePackages="bitcamp.java110.cms") //객체를 만듬
@PropertySource("classpath:/bitcamp/java110/cms/conf/jdbc.properties")//읽어서 environment에 저장을함

// Mybatis에서 자동으로 DAO를 생성할 때 사용할 인터페이스가 들어 있는 패키지 설정
@MapperScan("bitcamp.java110.cms.dao")
public class AppConfig {
    
    @Autowired
    Environment env;
    
    @Bean(destroyMethod="close")
    public DataSource datatSource() {
        
        
        System.out.println("DataSrouce 객체 생성!");
        
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(env.getProperty("jdbc.driver"));
        ds.setUrl(env.getProperty("jdbc.url"));
        ds.setUsername(env.getProperty("jdbc.username"));
        ds.setPassword(env.getProperty("jdbc.password"));
        ds.setDefaultAutoCommit(false);
        
        return ds;
    }
    
    @Bean
    public SqlSessionFactory sqlSessionFactory(
            DataSource dataSource,
            ApplicationContext appCtx) {
        System.out.println("SqlSessionFactory 객체 생성!");
        System.out.println(dataSource);
        System.out.println(appCtx);
        try {
            SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
            
            // DB 커넥션풀을 관리해주는 객체를 꼽는다.
            factory.setDataSource(this.datatSource());
            
            // SQL 맵퍼 파일에서  도메인 객체의 별명을 사용하려면,
            // 도메인 객체가 들어 있는 패키지를 지정해야 한다.
            // 그러면 Mybatis가 해당 패키지의 모든 클래스에 대해 별명을 자동으로 생성할 것이다.
            factory.setTypeAliasesPackage("bitcamp.java110.cms.domain");
            
            // SQL 맵퍼 파일 경로를 등록한다.
            factory.setMapperLocations(appCtx.getResources(
                            "classpath:/bitcamp/java110/cms/mapper/**/*.xml"));
                                                                //하위에 있는 .xml 다가져와
            
            return factory.getObject();
            
        } catch (Exception e) {
            throw new RuntimeException(e); 
        }
    }
    
/* public static void main(String[] args) {
        
        // Java Config를 사용할 때는 다음 IoC 컨테이너를  사용한다.
        ApplicationContext iocContainer = 
                new AnnotationConfigApplicationContext(AppConfig.class);
        
        System.out.println("------------------------------");
        
        // 컨테이너에 들어 있는 객체의 개수와 이름 알아내기
        int count = iocContainer.getBeanDefinitionCount();
        System.out.printf("bean 개수 = %d\n", count);
        
        String[] names = iocContainer.getBeanDefinitionNames();
        for (String name : names) {
            System.out.printf("=> %s : %s\n", 
                    name, 
                    iocContainer.getType(name).getName());
        }
        
        System.out.println("------------------------------");
        
    }*/

}