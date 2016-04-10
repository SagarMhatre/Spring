* Added Spring Bean Configuration file \src\main\resources\spring.xml. Selected the beans schema.
* Classes RESTConnector & HTTPConnector extend Interface in.mhatre.sagar.spring.core.beans.Connector
* Retrieved a bean using Application Context
* Added a private String url to the RESTConnector & HTTPConnector.
* Initialized the url of the connector bean through property tag.
* Autowired bean of in.mhatre.sagar.spring.core.beans.HealthChecker (which has a private member of name connector + getter setters for it & no-args constructor ) byName
* Autowired bean of in.mhatre.sagar.spring.core.beans.HealthChecker (which has a private member of type Connector + getter setters for it & no-args constructor ) byType
* Implemented ApplicationContextAware to get a handle to the ApplicationContext created somewhere else. REquires instantiation of the implementor through spring & not by new
 