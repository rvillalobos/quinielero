<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<link href="webapp/css/new_style.css" rel="stylesheet" type="text/css" />
<link href="webapp/css/custom_style.css" rel="stylesheet" type="text/css" />
<title>Untitled 1</title>

<SCRIPT>function listbox_move(listID,direction){var listbox=document.getElementById(listID);var selIndex=listbox.selectedIndex;if(-1==selIndex){alert("Please select an option to move.");return;}
var increment=-1;if(direction=='up')
increment=-1;else
increment=1;if((selIndex+increment)<0||(selIndex+increment)>(listbox.options.length-1)){return;}
var selValue=listbox.options[selIndex].value;var selText=listbox.options[selIndex].text;listbox.options[selIndex].value=listbox.options[selIndex+increment].value
listbox.options[selIndex].text=listbox.options[selIndex+increment].text
listbox.options[selIndex+increment].value=selValue;listbox.options[selIndex+increment].text=selText;listbox.selectedIndex=selIndex+increment;}
function listbox_moveacross(sourceID,destID){var src=document.getElementById(sourceID);var dest=document.getElementById(destID);for(var count=0;count<src.options.length;count++){if(src.options[count].selected==true){var option=src.options[count];var newOption=document.createElement("option");newOption.value=option.value;newOption.text=option.text;newOption.selected=true;try{dest.add(newOption,null);src.remove(count,null);}catch(error){dest.add(newOption);src.remove(count);}
count--;}}}
function listbox_selectall(listID,isSelect){var listbox=document.getElementById(listID);for(var count=0;count<listbox.options.length;count++){listbox.options[count].selected=isSelect;}}</SCRIPT>

</head>

<body>

<jsp:useBean id="obj" class="com.iteso.sweng.Pool.EditTeamsServlet" scope="page"/>

<div class="container_12">

    <div class="grid_4 suffix_8">
        <a class="logo" href="/sso"></a>
    </div>

    <div class="box-content">
        
            <div class="row">

            <table>
                <tr>
                    <!-- AVAILABLE TEAMS -->
                    <td>
                        <select id="availableTeams_id" class="selectTable" size="5" name="availableTeams_box">
                            <c:forEach var="team" items="${availableTeams}">
                                <option> ${team.name} </option>
                            </c:forEach>
                        </select>
                    </td>
                    <td>
                    <div>
                        <input  class="button addRemoveButton " name="addTeam_btn" type="button" value="Add >>" onclick="listbox_moveacross('availableTeams_id', 'addedTeams_id')" />
                        <input  class="button addRemoveButton " name="removeTeam_btn" type="button" value="Remove <<" onclick="listbox_moveacross('addedTeams_id', 'availableTeams_id')" />
                    </div>

                    <!-- ADDED TEAMS -->
                    </td>
                    <td>
                        <select id="addedTeams_id" class="selectTable" size="5" name="addedTeams_box">
                            <c:forEach var="team" items="${addedTeams}">
                                <option> ${team.name} </option>
                            </c:forEach>

                        </select>
                    </td>
                </tr>
            </table>
            </div>

            
            <fieldset class="saveButton">
            <form name="saveChanges" action="SaveTeamsServlet" method="post" >
            <div class="row">
                <input class="button" name="saveTeams_btn" type="submit" value="Save" />
            </div>
            </form>
            </fieldset>
            
        
    </div>
</div>

</body>

</html>
