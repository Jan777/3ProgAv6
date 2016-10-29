# Creacion del personaje

### Cliente envia el personaje creado 

{"idPErsonaje" : "001", "energia" : 100, "salud" : 100, "fuerza" : 1 , "destreza" : 1 , "inteligencia : 1, "casta" : "guerrero" }

# Ingresar a un mapa y recorrerlo  

##El Servidor envia al cliente los distintos mapas 

{["mapa": "dust", "mapa": "atacama" ]}

## El Cliente envia el mapa seleccionado
{"mapa":"dust"}

## El Cliente envia posicion 

{ "ubicacion" :{"x" : 200 , "y" :200} }
## Servidor envia la posicion a todos los demas clientes
{"id personaje " : 001 , "ubicacion" :{"x": 200 , "y" :200}}

# Manejar Items

## Cliente envia el item a equipar

{"item": "ConPapiroDePotter" , "accion" : "equipar" }

## Cliente envia item a desequipar

{"item" : ConPapiroDePotter" , "accion" : "desequipar" } 


# Manejar Alianzas 

## cliente envia al servidor solicitud de alianza

{"accion" : "aliar" , "idPersonajeAAliar" : "002" } 

# Servidor envia solicitud de alianza al posible aliado

{ "accion" : "aliar" , "idPersonajeSolicitante" : "001" }

# El otro cliente responde a la solicitud 
{"respuesta" true }

# Cliente envia al servidor la solicitud para salir de la alianza
{"accion" : "abandonarAlianza" , "idAlianza" : 1010}

#Servidor reponde si es posible salir de alianza
{"salirDeAlianza" : true }

# Iniciar Pelea

## Cliente inicia pelea  y la envia al servidor 

{"accion" : "pelea", "idPersonajeAPelar" : 003}

## Servidor inicia el escenario de batalla y carga los batallones de cada jugador 

{"ventana" : "batalla" , "batallon1": [ {"idPersonaje" : "001"} . {"idPersonaje" : "002"} ] , "batallon2" :[{"idPersonaje" : "003" }]} 

