### battp-sql-parser

> 向druid,sharding-jdbc致敬.

### 说明

#### 为什么有这个项目?

首先,完整的sql语句语法是很复杂的,有sql标准的,也有各个db的方言,以MySQL为例:[SQL Statement Syntax](https://dev.mysql.com/doc/refman/8.0/en/sql-syntax.html)
而某些场景下,我们仅需要解析sql的一小部分,如:读写分离判断,还有很多互联网场景,这样,battp-sql-parser应运而生.

#### 当前开源的sql parser状况?

- druid
    - 基于监控的数据库连接池,它要完全理解sql,故对sql解析做了很完善的支持.
    - 对sql语句语法支持很完善,缺点是没有单独作为组件,阿里内部好像在做了,对外估计得猴年马月了.
- sharding-jdbc
    - 早期核心功能是支持分库分表,基于JDBC Driver增强,对应用层透明.
    - 与druid不同,它仅需要理解它需要的部分即可,叫半理解.

### 用途

- sql语句读写分离判断




