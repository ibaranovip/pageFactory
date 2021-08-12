# pageFactory
<p>&nbsp;</p>
<p>Архитектура тестового проекта основана на классе Page Factory из библиотеки Selenium.</p>
<p><strong>WebDriver and browser:</strong><br />java/project/browser/<strong>BrowserFactory.java</strong> - класс enum с перечислением Browser type;<br />java/project/browser/<strong>Configuration.java</strong> - Owner отличная библиотека для работы с properties;<br />java/project/browser/<strong>ConfigurationManager.java</strong> - Позволяет объекту <strong>Config</strong> из библиотеки Owner получать доступ к содержимому полей класса Configuration.java для выполнения последующих операций;<br />java/project/browser/<strong>DriverManager.java</strong> - здесь определены методы getDriver, setDriver;<br />java/project/browser/<strong>TargetFactory.java</strong> - с помощью операторов switch and case определяем LOCAL or REMOTE цель запуска тестового проекта;</p>
<p><strong>Exception:</strong><br />java/project/exceptions/<strong>HeadlessNotSupportedException.java</strong> - исключение в случае если Headless Not Supported Browser<br />java/project/exceptions/<strong>TargetNotValidException.java</strong> - не определен вид LOCAL or REMOTE;</p>
<p><br /><strong>Initialiazation PagePattern:</strong><br />java/project/pages/<strong>BasePage.java</strong> - инициализация класса selenium PageFactory и веб драйвера(DriverManager class). Этот класс имеет конструктор, чтобы исключить необходимость инициализации элементов с помощью Page Factory. Кроме того, он устанавливает тайм-аут из значения свойства тайм-аута, расположенного в файле general.properties. Все классы объектов Page должны расширять объект BasePage.java;</p>
<p><strong>Page Object:</strong><br />java/project/pages/<strong>LoginPage.java</strong> - "Object Page", шаблон нашей тестовой страницы унаследованной от класса BasePage.java, происходит объявление веб элеметов (Webelement) как полей класса;<br />&nbsp;</p>
<p><strong>Report:</strong><br />java/project/util/<strong>AllureManager.java</strong> - определен метод setAllureEnvironmentInformation,определяющий окружение для allure<br />java/project/util/<strong>BrowserUtil.java</strong> - здесь определеный дополнительные методы для работы с веб элементами;src/test/java/projectTest/<strong>TestListener.java</strong> -класс, реализующий ITestListener. используется для облегчения регистрации ошибок и добавления дополнительной информации к отчету о тестировании
  </p>
  <p><br />
  Data generator<br /></p>
  <p>java/project/util/<strong>DataGenerator.java</strong> - генерация фейковых данных для тестовой регистрации</p>
<p><strong>Logging</strong></p>
<p>Весь журнал ведется c помощью Log4J с использованием аннотации @ Log4j2.&nbsp;</p>
<p>В log4j2.properties есть две стратегии: консольная и файловая. Файл со всей информацией журнала будет автоматически создан в папке пользователя с именем test_automation.log. Если вы хотите его изменить, обновите значение свойства appender.file.fileName. Log.error используется для регистрации всех исключений, которые может вызывать эта архитектура.&nbsp;log.info или log.debug для регистрации важной информации, такой как пользователи, автоматически генерируемой dataGenerator<strong>.</strong></p>
<p><strong>Properties</strong><br />
  <p>В src/main/resources/ есть 3 файла свойств (конфигурации):</p>
<p>general.properties:&nbsp; базовый URL, тайм-аут и локализация;<br />grid.properties: URL-адрес и порт для использования grid Selenium ;<br />local.properties: браузер для использования в локальном исполнении;</p>
<p>В src/main/resources/log4j2.properties  настройки для log4j2;</p>
<br /></p>
<p><strong>Test Case/ Test Suite:</strong><br />src/test/java/projectTest/<strong>BaseTest.java</strong> - Предварительное условие использует @Beforetest из TestNG, создает экземпляр браузера на основе значений, переданных либо локальному, либо удаленному выполнению. Постусловие использует @AfterMethod для закрытия экземпляра браузера.<br />src/test/java/projectTest/LoginTest.java - тестовый случаи;</p>
<p><br /><strong>Define profile test suite:</strong><br />src/test/resources/suites/local.xml <br />src/test/resources/suites/parallel.xml</p>
 <p>Здесь определен профиль вызова test suite - web-execution</p>
<p>профиль, web-execution, созданный&nbsp; в pom.xml для выполнения пакета тестов local.xml/parallel.xml из command line.</p>
<p>Чтобы выполнить этот suite через командную строку вы можете вызвать параметр -P и&nbsp; профиль. Example:</p>
<p style="padding-left: 40px; text-align: justify;"><strong>Запуск тестов и отчетов</strong></p>
<p>local</p>
<pre>mvn <span class="pl-c1">test</span> -P web-execution -D testng.dtd.http=true<br /><br /></pre>
<p>parallel</p>
<pre>mvn test -P web-execution -D suite=parallel -Dtestng.dtd.http=true </pre>
<p>Generate allure report;</p><br> <pre>allure serve target/allure-results</pre></p>
