<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>ADD PERSON</title>
    <link href="<c:url value="/WEB-INF/pages/css/bootstrap.min.css"/>" rel="stylesheet">
</head>
<body>
<h1>Hello, world!</h1>

<div class="btn-group">
    <button type="button" class="btn btn-default">Left</button>
    <button type="button" class="btn btn-default">Middle</button>
    <button type="button" class="btn btn-default">Right</button>
</div>


<div>
    <h2>Создать аккаунт</h2>
    <sf:form method="POST" modelAttribute="user" action="save"> <!-- Связать форму -->
        <fieldset> <!-- с атрибутом модели -->
            <table cellspacing="0">
                <tr>
                    <th><label for="user_name">Имя:</label></th>
                    <td><sf:input path="name" size="50" id="user_name"/></td>
                </tr>
                <tr>
                    <th><label for="user_surname">Фамилия:</label></th>
                    <td><sf:input path="surname" size="50" maxlength="50"
                                  id="user_surname"/> <!-- Поле имени пользователя -->
                        <small id="username_msg">No spaces, please.</small>
                    </td>
                </tr>
                <tr>
                    <th><label for="user_patronymic">Отчество:</label></th>
                    <td><sf:input path="patronymic" size="50" maxlength="50"
                                  id="user_patronymic"/> <!-- Поле имени пользователя -->
                        <small id="username_msg">No spaces, please.</small>
                    </td>
                </tr>
                <tr>
                    <th><label for="user_username">Логин:</label></th>
                    <td><sf:input path="username" size="30"
                                  showPassword="true"
                                  id="user_username"/> <!-- Поле пароля -->
                        <small>6 characters or more (be tricky!)</small>
                        <sf:errors path="error" cssClass="error" />
                    </td>
                </tr>
                <tr>
                    <th><label for="user_password">Пароль:</label></th>
                    <td><sf:password path="password" size="30"
                                     showPassword="true"
                                     id="user_password"/> <!-- Поле пароля -->
                        <small>6 characters or more (be tricky!)</small>
                    </td>
                </tr>
                <tr>
                    <th><label>Уровень доступа:</label></th>
                    <td>
                        <sf:radiobutton path="role" value="3" id="student_access"/>Студент
                        <sf:radiobutton path="role" value="2" id="teacher_access"/>Преподаватель
                        <sf:radiobutton path="role" value="1" id="administrator_access"/>Администратор
                    </td>
                </tr>
                <tr>
                    <td>
                        <input name="commit" type="submit" value="Создать аккаунт"/>
                    </td>
                </tr>
            </table>
        </fieldset>
    </sf:form>
</div>

<script src="<c:url value="/WEB-INF/pages/js/bootstrap.min.js"/>"></script>
</body>
</html>
