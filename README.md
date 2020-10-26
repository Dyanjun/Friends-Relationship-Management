# Friends-Relationship-Management

#数据库
mysql
Neo4j

#UserNode存用户节点。由于User的username是唯一的，所以在UserNode中除id外只需储存username。从而UserNode用于好友关系管理，User用于与其他类的join操作。

#UserFriendship存用户关系。由属性 String friendship（username1->username2）识别。

#UserNodeService实现对好友关系的添加和删除。添加时需要判断User中是否有目标用户，如果没有，则在UserNode和UserFriendship中不添加。

#代码注意事项

-neo4j用的@id等注释与mysql中是不同的

-关系类的startnode和endnode不会在边上显示，需要另外设一个属性去识别边

-启动类需要添加注释@EnableNeo4jRepositories，否则接口实例无法注入到service中
