# ngannsophal-maven-spring-exercise
(Spring REST-API with Jdbc template) :
# Create database    
```java
=====initial sql schema.sql======== run it mysql console
DROP DATABASE IF EXISTS rupp_test;
CREATE DATABASE rupp_test;
USE rupp_test;
         
DROP TABLE IF EXISTS customers;
CREATE TABLE IF NOT EXISTS `customers` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `firstName` varchar(30) NOT NULL,
  `lastName` varchar(30) NOT NULL,
  `gender` char(1) NOT NULL COMMENT 'M:Male, F:Female',
  `email` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `address` varchar(100) NOT NULL,
  `dob` date NOT NULL,
  `createDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
 
INSERT INTO `customers` (`id`, `firstName`, `lastName`, `gender`, `email`, `phone`, `address`, `dob`, `createDate`) VALUES
	(1, 'Sophal', 'Ngann', 'M', 'ngannsophal12@gmail.com', '070306035', 'pp Cambodia', '2000-02-25', '2017-03-01 21:58:20'),
	(2, 'Prep', 'Sowat', 'M', 'sprep@abc.com', '012547938', 'Sihanouvill cambodia', '1982-05-27', '2017-03-01 21:58:20'),
	(3, 'Chan', 'Sok', 'F', 'csok@bgt.com', '0231472365', 'Kompong cham', '2005-01-12', '2017-03-01 21:58:20'),
	(4, 'Choun', 'Py', 'F', 'pchoun@test.com', '070325987', 'Prey veng', '2003-03-19', '2017-03-01 21:58:20'),
	(5, 'Jhon', 'Sy', 'M', 'sjhon@act.org', '012456987', 'svay reing', '1997-06-30', '2017-03-01 21:58:20'),
	(6, 'Mary', 'Koy', 'F', 'kmary@tyu.com', '092456123', 'Kom pot', '1979-04-18', '2017-03-01 21:58:20'),
	(7, 'Dainy', 'Rot', 'M', 'rdainy@pio.com', '096147258', 'Kom pongSpeu', '2001-01-28', '2017-03-01 21:58:20'),
	(8, 'Pisey', 'Sok', 'F', 'spisey@by.com', '097369852', 'Kandal', '1999-07-29', '2017-03-01 21:58:20'),
	(9, 'Saron', 'sopheap', 'M', 'ssaron@uyp.com', '061587496', 'Takeo', '1996-06-19', '2017-03-01 21:58:20'),
	(10, 'Obama', 'Bar', 'M', 'bobama@tes.org', '017258146', 'Koh kong', '1987-08-20', '2017-03-01 21:58:20'),
	(11, 'Clint', 'Men', 'F', 'mclint@yahoo.com', '023658747', 'kompong thom', '1987-01-03', '2017-03-01 21:58:20'),
	(12, 'Tabley', 'Wood', 'M', 'wtabley@hotmail.com', '016897569', 'pursat province', '1988-09-23', '2017-03-01 21:58:20'),
	(13, 'Naty1', 'Bo1', 'M', 'bnaty1@tp.org', '0236958471', 'canada1', '1897-05-11', '2017-03-01 21:58:20'),
	(14, 'Noy', 'Ty', 'M', 'tnoy@abc.edu', '023695847', 'United state of America', '2006-08-26', '2017-03-01 22:23:17'),
	(15, 'Prak', 'sok', 'M', 'sprak@teat.com', '012695847', 'USA', '1991-08-22', '2017-03-01 23:07:51'),
	(16, 'Ty', 'Po', 'F', 'pty@g.com', '01598763', 'Australia', '1999-02-16', '2017-03-01 23:34:53');

==============================================
```
Set DB username: "root" and DB password:empty in pom.xml
```
 <properties>
    <database.driver>com.mysql.jdbc.Driver</database.driver>
    <database.url>jdbc:mysql://localhost:3306/rupp_test?autoReconnect=true</database.url>
    <database.username>root</database.username>
    <database.password></database.password>    
    <spring.version>4.3.5.RELEASE</spring.version>    
  </properties>
```
Install maven

C:\workspace\ngannsophal-maven-spring-exercise>mvn clean install

Start jetty server with maven

mvn clean jetty:run

# CRUD REST-APIs :

- GET http://localhost:8080/api/customers/v1/all

- GET http://localhost:8080/api/customers/v1/{id}

- POST http://localhost:8080/api/customers/v1/{id}

- DELETE http://localhost:8080/api/customers/v1/{id}

- PUT http://localhost:8080/api/customers/v1/{id}

# Client html page crud action 
- http://localhost:8080/bootstrap-schema.html

# Maven spring-jdbc  
```java
<dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-jdbc</artifactId>
        <version>4.3.5.RELEAS</version>
</dependency>


 <!-- MySQL database driver -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>5.1.22</version>
    </dependency>
  <!-- common-dbcp2 -->
  <dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-dbcp2</artifactId>
    <version>2.1.1</version>
```



```java

=============web.xml===============

<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://java.sun.com/xml/ns/javaee"     xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd" version="2.5">
     
     
     <!-- Configure ContextLoaderListener to use AnnotationConfigWebApplicationContext
    instead of the default XmlWebApplicationContext -->
    <context-param>
        <param-name>contextClass</param-name>
        <param-value>org.springframework.web.context.support.AnnotationConfigWebApplicationContext</param-value>
    </context-param>

    <servlet>
        <servlet-name>spring-dispatcher</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <load-on-startup>1</load-on-startup>
        <init-param>
            <param-name>contextClass</param-name>
            <param-value>org.springframework.web.context.support.AnnotationConfigWebApplicationContext</param-value>
        </init-param>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>com.rupp.spring.config.MvcConfig</param-value>
        </init-param>
    </servlet>
    <servlet-mapping>
        <servlet-name>spring-dispatcher</servlet-name>
        <url-pattern>/api/*</url-pattern>
    </servlet-mapping>
     
   
    <!-- welcome file -->
   <welcome-file-list>  
   <welcome-file>index.jsp</welcome-file>  
   <welcome-file>index.html</welcome-file>  
  </welcome-file-list>  
</web-app>


====================Spring Java-based configuration============

package com.rupp.spring.config;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc //mvc:annotation-driven
@Configuration
@ComponentScan(value = {"com.rupp.spring.controller", "com.rupp.spring.service", "com.rupp.spring.dao"})
public class MvcConfig extends WebMvcConfigurerAdapter {
    
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        SkipNullObjectMapper skipNullMapper = new SkipNullObjectMapper();
        skipNullMapper.init();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(skipNullMapper);
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        skipNullMapper.setDateFormat(formatter);
        
        converters.add(converter);
    }
}

package com.rupp.spring.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SkipNullObjectMapper extends ObjectMapper {

    //@SuppressWarnings("deprecation")
    public void init() {
        setSerializationInclusion(JsonInclude.Include.NON_NULL);

        disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }
}

============Create REST-APIs with Spring Controller==========

package com.rupp.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rupp.spring.domain.DCustomer;
import com.rupp.spring.service.CustomerService;

@Controller
@RequestMapping("customers")
public class CustomerController {
    @Autowired
    private CustomerService service;
    

    
    //@RequestMapping(value = "/v1", method = RequestMethod.GET)
    @GetMapping("/v1/all")
    @ResponseBody
    public List<DCustomer> getDCategories() {
        return service.list();
    }

    //@RequestMapping(value = "/v1/{id}", method = RequestMethod.GET)
    @GetMapping("/v1/{id}")
    public ResponseEntity<DCustomer> getDCustomer(@PathVariable("id") Long id) {

        DCustomer customer = service.get(id);
        if (customer == null) {
            return new ResponseEntity("No DCustomer found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    //@RequestMapping(value = "/v1", method = RequestMethod.POST)
    @PostMapping(value = "/v1")
    public ResponseEntity<DCustomer> createDCustomer(@RequestBody DCustomer customer) {

        service.create(customer);

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    //@RequestMapping(value = "/v1/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/v1/{id}")
    public ResponseEntity deleteDCustomer(@PathVariable Long id) {

        if (null == service.delete(id)) {
            return new ResponseEntity("No DCustomer found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(id, HttpStatus.OK);

    }
    //@RequestMapping(value = "/v1/{id}", method = RequestMethod.PUT)
    @PutMapping("/v1/{id}")
    public ResponseEntity updateDCustomer(@PathVariable Long id, @RequestBody DCustomer customer) {

        customer = service.update(id, customer);

        if (null == customer) {
            return new ResponseEntity("No DCustomer found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(customer, HttpStatus.OK);
    }
}
====================

Service layer :
===================
package com.rupp.spring.service;

import java.util.List;

import com.rupp.spring.domain.DCustomer;

public interface CustomerService {
    List<DCustomer> list();
    DCustomer get(Long id);
    DCustomer create(DCustomer dCustomer);
    Long delete(Long id);
    DCustomer update(Long id, DCustomer dCustomer);
}

package com.rupp.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rupp.spring.dao.CustomerDao;
import com.rupp.spring.domain.DCustomer;

@Service("customerSevice")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao dao;
    
    @Override
    public List<DCustomer> list() {
        return dao.list();
    }

    @Override
    public DCustomer get(Long id) {
        return dao.get(id);
    }

    @Override
    public DCustomer create(DCustomer dCustomer) {
        return dao.create(dCustomer);
    }

    @Override
    public Long delete(Long id) {
        return dao.delete(id);
    }

    @Override
    public DCustomer update(Long id, DCustomer dCustomer) {
        
        if (dao.get(id) == null) {
            return null;
        }
        dCustomer.setId(id);
        return dao.update(dCustomer);
    }
}

==================================dao Layer==========
 package com.rupp.spring.dao;

import java.util.List;

import com.rupp.spring.domain.DCustomer;

public interface CustomerDao {
    List<DCustomer> list();
    DCustomer get(Long id);
    DCustomer create(DCustomer dCustomer);    
    Long delete(Long id);
    DCustomer update(DCustomer dCustomer);
}
 
package com.rupp.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.rupp.spring.domain.DCustomer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
    
    private JdbcTemplate jdbcTemplate;
    
    public CustomerDaoImpl() {
        jdbcTemplate = new JdbcTemplate(DBCP2DataSourceUtils.getDataSource());
    }
    public List<DCustomer> list() {
        final String sql = "select * from customers";
        //List<DCustomer> list = this.jdbcTemplate.queryForList(sql,DCustomer.class);
        List<DCustomer> list = this.jdbcTemplate.query(sql, new RowMapper<DCustomer>() {

            @Override
            public DCustomer mapRow(ResultSet rs, int paramInt) throws SQLException {
                final DCustomer domain = new DCustomer();
                domain.setId(rs.getLong("id"));
                //domain.setName(rs.getString("name"));
                //domain.setCreatedDate(new Date(rs.getTimestamp("createdDate").getTime()));
                domain.setFirstName(rs.getString("firstName"));
                domain.setLastName(rs.getString("lastName"));
                domain.setGender(rs.getString("gender"));
                domain.setEmail(rs.getString("email"));
                domain.setPhone(rs.getString("phone"));
                domain.setAddress(rs.getString("address"));
                domain.setDob(new Date(rs.getDate("dob").getTime()));
                return domain;
            }
            
        });
        return list;
    }

    public DCustomer get(Long id) {
        final String sql = "select * from customers where id = ?";
        
        try {
            //select for object
            final DCustomer obj = jdbcTemplate.queryForObject(sql, new Object[] { id }, new RowMapper<DCustomer>() {

                @Override
                public DCustomer mapRow(ResultSet rs, int paramInt) throws SQLException {
                    final DCustomer domain = new DCustomer();
                    domain.setId(rs.getLong("id"));
                    domain.setName(rs.getString("firstName"));
                    domain.setCreatedDate(new Date(rs.getTimestamp("dob").getTime()));
                    return domain;
                }
            });
            return obj;
        } catch (EmptyResultDataAccessException e) {
            System.out.println("NOT FOUND " + id + " in Table" );
            return null;
        }
    }

    public DCustomer create(DCustomer dCustomer) {
        final String sql = "INSERT INTO customer (name) VALUES (?)";
        jdbcTemplate.update(sql, new Object[] { dCustomer.getName() });
        return dCustomer;
    }

    public Long delete(Long id) {
        final String sql = "Delete from customers where id =?";
        int result = jdbcTemplate.update(sql, new Object[] { id });
        return result == 1 ? id : null;
    }

    public DCustomer update(DCustomer dCustomer) {

        final String sql = "UPDATE customers set firstName =? , lastName =? , gender =? , email =? , phone =? , address =? , dob =? where id=?";
        int result = jdbcTemplate.update(sql, new Object[] { dCustomer.getFirstName() ,dCustomer.getLastName(),	dCustomer.getGender(), dCustomer.getEmail(), dCustomer.getPhone(),	dCustomer.getAddress(),
												        		dCustomer.getDob(),	dCustomer.getId()});
        return result == 1 ? dCustomer : null;

    }
}

=======================DBCP2 Datasource connection========
package com.rupp.spring.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
/**
 * @author Sophea <a href='mailto:smak@dminc.com'> sophea </a>
 * @version $id$ - $Revision$
 * @date 2017
 */
public class DBCP2DataSourceUtils {
    private static BasicDataSource ds = null;
    
    static {
        String propsFile = "db.properties";
        Properties props = new Properties();
        
        try {
            props.load(Thread.currentThread().getContextClassLoader().getResource(propsFile).openStream());
            ds = BasicDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
            props = null;
        }
    }
    /**get connection from pool*/
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    
    public static DataSource getDataSource() {
        return ds;
    }
    public static void printDataSourceState() {
        System.out.println("NumActive: " + ds.getNumActive());
        System.out.println("NumIdle: " + ds.getNumIdle());
    }
    }
==================================db.properties============
driverClassName=com.mysql.jdbc.Driver
url=${database.url}
username=${database.username}
password=${database.password}

=====Maven to replace these properties=======
<properties>
    <database.driver>com.mysql.jdbc.Driver</database.driver>
    <database.url>jdbc:mysql://localhost:3306/rupp_test?autoReconnect=true</database.url>
    <database.username>root</database.username>
    <database.password></database.password>    
  </properties>
  
```
Gitignore not working
(http://stackoverflow.com/questions/25436312/gitignore-not-working)
```
