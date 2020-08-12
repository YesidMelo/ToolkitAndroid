# ToolkitAndroid
Esta libreria tiene un conjunto de clases que permiten mejorar el tiempo de desarrollo facilitando la implementacion.

## Instalacion
 1. En build.gradle a nivel de proyecto insertar:
 ``` [language]
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  ```
  
  2. En build.gradle a nivel de app adicionar el siguiente codigo
  ``` [language]
    dependencies {
	        implementation 'com.github.YesidMelo:ToolkitAndroid:v1.0.2'
	  }
  ``` 
