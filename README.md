* Added Spring Bean Configuration file \src\main\resources\spring.xml. Selected the beans schema.
* Classes RESTConnector & HTTPConnector extend Interface in.mhatre.sagar.spring.core.beans.Connector
* Retrieved a bean using Application Context
* Added a private String url to the RESTConnector & HTTPConnector.
* Initialized the url of the connector bean through property tag.
* Autowired bean of in.mhatre.sagar.spring.core.beans.HealthChecker (which has a private member of name connector + getter setters for it & no-args constructor ) byName
* Autowired bean of in.mhatre.sagar.spring.core.beans.HealthChecker (which has a private member of type Connector + getter setters for it & no-args constructor ) byType
* Implemented ApplicationContextAware to get a handle to the ApplicationContext created somewhere else. REquires instantiation of the implementor through spring & not by new
* Implemented BeanNameAware to get name of the bean
* Used parent=&lt;Bean Name;gt; to inherit a template bean
* Used abstract="true" to define template
* Used <list merge="true"> to append to a list partially filled by the parent template bean
* Declaring a bean of class org.springframework.beans.factory.annotation.RequiredAnnotationBeanPostProcessor & annotating setters with @Required makes it mandatory to set the member variable even for template beans
* @Resource = Autowire byName or use @Resource(name = "beanId")
* @Qualifier("useThisQualifiedConnector") can be used to autowire a bean tagged by using the <qualifier value="useThisQualifiedConnector" /> when multiple beans of the type exist & autowiring byType is not feasible
* &lt;context:component-scan base-package="package containing classes annotated with @Component / @Service / @Repository  / @Controller. A bean with bean name = class name starting with lower case  will automatically be created for each such class" /&gt;
* @PostConstruct & @PreDestroy annotated methods are called after construction & before Destruction of the Bean. Also note AbstractApplicationContext's registerShutdownHook() method
* CustomEvent extends ApplicationEvent,   CustomEventListener implements ApplicationListener<ApplicationEvent> & Overrides	public void onApplicationEvent(ApplicationEvent appEvent) , CustomEventPublisher implements ApplicationEventPublisherAware & Overrides 	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) in which it assigns the  applicationEventPublisher to it's private member so that later it can use applicationEventPublisher.publishEvent(applicationEvent). We could also use applicationContext.publishEvent(myCustomEvent)   