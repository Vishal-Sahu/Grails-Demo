<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title>summary</title>
</head>

<body>
<div id="list-customer" class="content scaffold-list" role="main">

<div style="background-color:#FF0000;">
    <h1>Failed Charges</h1>
    <table>
        <tr>
            <td><h4>Customers Name</h4></td>
            <td><h4>Amount</h4></td>
            <td><h4>Date</h4></td>

        </tr>

        <g:each in="${failedChargesList}" var="failedCharge">
            <tr>
                <td>${failedCharge.customer.fullName}</td>
                <td>${failedCharge.amount} ${failedCharge.currency}</td>
                <td><g:formatDate date="${failedCharge.dateCreated}" format="MM dd yyyy"/></td></tr>
        </g:each>
    </table>
</div>
<div style="background-color:#FF5400;">
    <h1>Refunded Charges</h1>
    <table>
        <tr>
            <td><h4>Customers Name</h4></td>
            <td><h4>Amount</h4></td>
            <td><h4>Date</h4></td>

        </tr>

        <g:each in="${refundedChargesList}" var="refundedCharge">
            <tr>
                <td>${refundedCharge.customer.fullName}</td>
                <td>${refundedCharge.amount} ${refundedCharge.currency}</td>
                <td><g:formatDate date="${refundedCharge.dateCreated}" format="MM dd yyyy"/></td></tr>
        </g:each>
    </table>
</div>

<div style="">
    <h1>Successful Charges</h1>
    <table>
        <tr>
            <td><h4>Customers Name</h4></td>
            <td><h4>Amount</h4></td>
            <td><h4>Date</h4></td>

        </tr>

        <g:each in="${successChargesList}" var="successCharge">
            <tr>
                <td>${successCharge.customer.fullName}</td>
                <td>${successCharge.amount} ${successCharge.currency}</td>
                <td><g:formatDate date="${successCharge.dateCreated}" format="MM dd yyyy"/></td></tr>
        </g:each>
    </table>
</div>
</div>
</body>
</html>