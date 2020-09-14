<#import "/spring.ftl" as spring/>

<!DOCTYPE html>

<html lang="en">

<head>

    <meta charset="UTF-8">
    <title>Create/Edith</title>

</head>

<body style="margin: 0; padding: 0; height: 100%; width: 100%; background: #08032b; color: white">

<form name="customers" action="" method="POST" style="width: 700px; height: 500px; line-height: 2; margin-left: 15px; margin-top: 8px">

    Name:<@spring.formInput "productsForm.name" "" "text"/>
    <br>
    Material code:<@spring.formSingleSelect "productsForm.materialCode", mavs1, ""/>
    <br>
    Precious stone:<@spring.formSingleSelect "productsForm.preciousStoneName", mavs2, ""/>
    <br>
    Mass:<@spring.formInput "productsForm.mass" "" "text"/>
    <br>
    Price:<@spring.formInput "productsForm.price" "" "text"/>
    <br>
    Description:<@spring.formInput "productsForm.descriction" "" "text"/>
    <br>

    <input type="submit" value="Next" style="width: 70px; height: 28px; background: #206b19"/>

</form>

</body>

</html>