# Aplazo Test de Micro Servicio

En la raíz del proyecto hay un archivo Dockerfile 
con el cual se construye 
el contenedor en el cual se ejecutará el proyecto.


-
## Payments calculator endpoint

1.- En la siguiente tabla podrás ver la información del endpoint que se necesitará ejecutar para realizar el proceso del calculo de pagos

| Endpoint | http://localhost:8080/paymentCredit/getRatePayments/                |
|----------|---------------------------------------------------------------------|
| Method   | POST                                                                |
| Body     | { "amount": Double, "terms": Integer, "rate": Double }              |
| Response | { "amount": Double, "paymentNumber": Integer, "paymentDate": Date } |

## Health endpoint

Para acceder al health endpoint, ingresar a los endpoints correspondiente 
por medio de un GET después de tener el jar en ejecución

```sh
http://localhost:8080/actuator
http://localhost:8080/actuator/health
```