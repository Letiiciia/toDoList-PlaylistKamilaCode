### serie-todo-list-youtube da Kamila Code

Consiste no desenvolvimento de uma aplicação semelhante a uma to do list (lista de tarefas), onde será possível cadastrar tarefas, listar tarefas, buscar tarefas pelo id, editar e excluir tarefas (CRUD).

### 🛠 Tecnologias utilizadas:
- Java 11
- Spring
- H2 Database
- (Springfox)
- Heroku
- Postresql

### 🎲 Utilizando os endpoints

```bash
# Para acessar a docuemntação no Swagger - acesse <http://desolate-caverns-89591.herokuapp.com/swagger-ui.html#/task-controller>
# Para cadastrar um todo:
modelo do body
{
	"title": "gravando o terceiro video",
	"description": "video sobre criação e listagem",
	"deadLine": "2021-11-28T12:23:00"
}
endpoint post ->   https://desolate-caverns-89591.herokuapp.com/api/v1/tasks<br>
# Para listar um todo: 
endpoint get ->   https://desolate-caverns-89591.herokuapp.com/api/v1/tasks<br>
# Para atualizar um todo: 
endpoint put ->   https://desolate-caverns-89591.herokuapp.com/api/v1/tasks/1<br>
# Para deletar um todo:
endpoint delete ->   https://desolate-caverns-89591.herokuapp.com/api/v1/tasks/1
```
