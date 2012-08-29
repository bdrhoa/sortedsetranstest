<!--
  To change this template, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="layout" content="main" />
    <title>Sample title</title>
  </head>
  <body>
    <h1>Add A Record</h1>

  <g:if test="${flash.message}">
    <div class="message">${flash.message}</div>
  </g:if>
  <g:if test="${flash.errors}">
    <div class="errors">
      <ul>
      <g:render template="renderflasherrors" collection="${flash.errors}"  as="list"/>
      </ul>
    </div>
  </g:if>


  <g:form action="add" name="doAdd">
    <table>
      <tr>
        <td>
          Parent Name
        </td>
        <td>
          Child Name
        </td>
        <td>
          Pet Name
        </td>
      </tr>
      <tr>
        <td>
      <g:textField name="parentName" value="${params?.parentName}" />
      </td>
      <td>
      <g:textField name="childName" value="${params?.childName}" />
      </td>
      <td>
      <g:textField name="petName" value="${params?.petName}" />
      </td>
      </tr>
      <tr><td><g:submitButton name="update" value="Update" /></td></tr>
    </table>
  </g:form>
</body>
</html>
