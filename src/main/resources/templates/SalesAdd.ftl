<#import "/spring.ftl" as spring/>

<!DOCTYPE html>

<html lang="en">

<head>

    <meta charset="UTF-8">
    <title>Create/Edith</title>

</head>

<body style="margin: 0; padding: 0; height: 100%; width: 100%; background: #08032b; color: white">

<form name="customers" action="" method="POST" style="width: 700px; height: 500px; line-height: 2; margin-left: 15px; margin-top: 8px">

    Product ID:<@spring.formSingleSelect "salesForm.productId" mavs1 ""/>
    <br>
    Date(Day.Month.Year):<@spring.formInput "salesForm.date" "" "text"/>
    <br>
    Customer full name:<@spring.formSingleSelect "salesForm.fullName" mavs2 ""/>
    <br>
    Description:<@spring.formInput "salesForm.descriction" "" "text"/>
    <br>

    <input type="submit" value="Next" style="width: 70px; height: 28px; background: #206b19"/>

</form>

</body>

</html>