# ToolkitAndroid
Esta libreria tiene un conjunto de clases que permiten mejorar el tiempo de desarrollo facilitando la implementacion. Esta utilidad esta pensada para el lenguaje Kotlin

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

## Lista de utilidades
Esta libreria de clases contiene las siguientes clases : 

1. ManejadorProxyRetrofitRx
2. SolicitantePermisos

### Implementacion de ManejadorProxyRetrofitRx
1. Debes crear un enumerador de servicios que extiende de IServiceParameters. Esta clase esta pensada para funciones api rest con json
ejemplo : 
```[language]
enum class Servicios(
    private val url: String,
    private val metodo : IServiceParameters.Methods
) : IServiceParameters {
    traerGet("",IServiceParameters.Methods.GET),
    traerGetServicio1("Servicio1",IServiceParameters.Methods.GET),
    ;

    override fun getURL(): String {
        return url + complemento
    }

    override fun getMethods(): IServiceParameters.Methods {
        return metodo
    }

    private var complemento = ""
    override fun WithComplement(complement: String): IServiceParameters {
        this.complemento = complement
        return this
    }

    private var objetoAEnviar : IRetrofitParcelable ?= null
    override fun <T : IRetrofitParcelable> conObjetoAEnviar(objetoAEnviar: T): IServiceParameters {
        this.objetoAEnviar = objetoAEnviar
        return this
    }

    override fun traerObjetoAEnviar(): IRetrofitParcelable? {
        return objetoAEnviar
    }

    private var claseObjetoEsperado : Class<*> ?= null
    override fun <T : IRetrofitParcelable> conObjetoEsperado(objetoEsperado: Class<T>): IServiceParameters {
        this.claseObjetoEsperado = objetoEsperado
        return this
    }

    override fun traerClaseObjetoEsperado(): Class<*>? {
        return claseObjetoEsperado
    }
}
```

2. configurar el servicio en el cual se hara la consulta se debe ingresar un objeto que extienda de IRetrofitParcelable
ejemplo : 
```[language]
class MiObjetoAEnviar : IRetrofitParcelable
class MiObjetoARecibir : IRetrofitParcelable

traerGet.conObjetoAEnviar(MiObjetoAEnviar()).conObjetoEsperado(MiObjetoARecibir::class.java)
```

3. Realizar consulta usando la clase ManejadorProxyRetrofitRx
ejemplo de implementacion unica consulta:

```[language]
ManejadorProxyRetrofitRx()
	.conEscuchadorInicioConsulta{}
	.conEscuchadorFinConsulta{}
	.conEscuchadorFalla{error,servicio,codigo,servidor ->	}
	.conUrlBase("Mi url de servidor")
	.adicionarParametroACabecera("Content-Type","application/json")
	.adicionarConsulta(Servicios.traerGet){	objeto , codigoServidor ->	}
	.iniciarConsulta()
```
4. Realizar varias consultas.
ejemplo de implementacion 
```[languaje]

ManejadorProxyRetrofitRx()
	.conEscuchadorInicioConsulta{}
	.conEscuchadorFinConsulta{}
	.conEscuchadorFalla{error,servicio,codigo,servidor ->	}
	.conUrlBase("Mi url de servidor")
	.adicionarParametroACabecera("Content-Type","application/json")
	.adicionarConsulta(Servicios.traerGet){	objeto , codigoServidor ->	}
	.adicionarConsulta(Servicios.traerGetServicio1){objeto , codigoServidor ->	}
	.iniciarConsulta()

```
### SolicitantePermisos
La implementacion de esta clase se realiza de la siguiente manera : 
ejemplo
```[language]
private var solicitantePermisos : SolicitantePermisos ?= null 
------------------------
SolicitantePermisos(this)
                .adicionarPermisoASolicitar(Permisos.CAMERA)
                .adicionarPermisoASolicitar(Permisos.ACCESS_FINE_LOCATION)
                .conEscuchadorTengoLosPermisosHabilitados{
                    Log.e("Error","tengo todos los permisos")
                }
                .conEscuchadorNoTengoLosPermisosHabilitados {
                    Log.e("Error","no tengo todos los permisos")
                }
                .solicitarPermisos()
```

Adicionar en el AppCompatActivity 
```[Language]
override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        solicitante_permisos?.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
```
#### Notas:
 1. this es un AppCompatActivity
 2. puede adicionar mas permisos adicionando mas lineas
 ```[language]
 .adicionarPermisoASolicitar(Permisos.ACCESS_FINE_LOCATION)
 ```
