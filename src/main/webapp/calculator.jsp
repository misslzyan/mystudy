<%--
  Created by IntelliJ IDEA.
  User: xiaoyanzi
  Date: 16/6/11
  Time: 下午6:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JavaScript Loan Calculator</title>
    <style type="text/css">


    </style>
</head>
    <table>

        <tr><th>Enter Loan Data:</th><td></td><th>Loan Balance,Cumulative Equlity , and Interest Payments</th></tr>
        <tr><td>Amount of the loan ($):</td><td><input id="amount" onchange="calculate();"/></td>
            <td rowspan=8>
                <canvas id="graph" width="400" height="250"></canvas>
            </td>
        </tr>
        <tr><td>Annual interest (%):</td>
            <td><input id="apr" onchange="calculate();"/></td>
        </tr>
        <tr><td>Repayment period (years)</td>
            <td><input id="years" onchange="calculate();"/></td>
        </tr>
        <tr><td>Zipcode (to find lenders):</td>
            <td><input id="zipcode" onchange="calculate();"/></td>

        </tr>
        <tr><th>Approxmimate Payments:</th>
            <td><button onclick="calculate();">Calculate</button></td>
        </tr>
        <tr><td>Monthly payment:</td><td>$<span class="output" id="payment"></span></td></tr>
        <tr><td>Total payment:</td><td>$<span class="output" id="total"></span></td></tr>
        <tr><td></td></tr>
    </table>
<body>

</body>
</html>
