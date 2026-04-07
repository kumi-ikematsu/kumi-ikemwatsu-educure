spring.application.name=bookmanagement

# PostgreSQL接続設定
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=CYV94XpcfV
spring.datasource.driver-class-name=org.postgresql.Driver

# SQLの自動実行設定
spring.sql.init.mode=always
spring.sql.init.schema-locations=classpath:schema.sql
spring.sql.init.data-locations=classpath:data.sql

# MyBatis設定
mybatis.type-aliases-package=jp.educure.bookmanagement.entity
mybatis.configuration.map-underscore-to-camel-case=true
mybatis.mapper-locations=classpath*:/mapper/*.xml
