AUTOMATIZACION

Para ejecutar el proyecto es necesario tener:
- Java 11
- Maven 3.6.3
- IntelliJ Community
- Edge

Con sus variables de entorno establecidas,asi como tambien una variable de entorno extra la cual se debe llamar

- ENVIRONMENT=DEVELOPMENT

Esta debe de estar en las variables de entorno del sistema *(TOTALMENTE NECESARIO)*, ya que es la encargada de diferenciar los procesos tanto como para DEV como para PROD.
De lo contrario la ejecucion fallara inmediatamente

(linux)
export ENVIRONMENT=DEVELOPMENT
mvn test -Dcucumber.filter.tags=@AutomationAbstracta

Para ejecutar el proyecto es necesario abrir una terminal dentro de la carpeta "Automatizacion" y ejecutar el siguiente comando.

mvn test -Dcucumber.filter.tags=@AutomationAbstracta
