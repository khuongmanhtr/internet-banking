<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;1,300;1,400&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="icon" type="image/png" href="/assets/image/icon/bank.png"/>
    <link rel="stylesheet" href="/assets/css/base.css"/>
    <!-- <link rel="stylesheet" href="/assets/css/staff/header_footer.css"/> -->
    <link rel="stylesheet" href="/assets/css/banking-base.css"/>
    <title>Internet Banking - Hotel Management</title>
</head>
<body>
<!-- Header -->
<header class="banking-header">
    <div class="grid">
        <div class="banking-navbar">
            <div class="banking__navbar-part">
                <div class="banking__navbar-logo" style="text-align:left;">
                    <img src="/assets/image/logo/bank.svg" alt="logo" class="banking__navbar-logo-img">
                </div>
                <div class="banking__navbar-part-title">INTERNET BANKING</div>
                <div class="banking__navbar-logo" style="text-align:right;">
                    <img src="/assets/image/logo/bank.svg" alt="logo" class="banking__navbar-logo-img">
                </div>
            </div>
        </div>
    </div>
</header>

<div class="banking">
    <h1 class="banking__heading">WELCOME TO OUR INTERNET BANKING</h1>
        <div class="banking__account-information">
            <div class="grid">
                <div class="grid-row">
                    <div class="grid-col grid-col-6">
                        <h3 class="banking__account-info-heading">search account number</h3>
                        <form action="/search" method="get" class="banking__account-search-form">
                            <div class="banking__account-search-number">
                                <label class="banking__account-search-label">Account Number:</label>
                                <input type="text" name="account" class="banking__account-search-input">
                            </div>
                            <div class="banking__account-search-action">
                                <button class="pill-btn green-type-btn banking__account-search-btn">Search</button>
                            </div>
                        </form>
                    </div>
                    <div class="grid-col grid-col-6">
                        <h3 class="banking__account-info-heading">Account information</h3>
                        <c:choose>
                            <c:when test="${account != null}">
                                <div class="banking__account-result">
                                    <div class="banking__account-result-detail">
                                        <span class="banking__account-result-title">Account Owner:</span>
                                        <span class="banking__account-result-desc">${account.accountOwner}</span>
                                    </div>
                                    <div class="banking__account-result-detail">
                                        <span class="banking__account-result-title">Account Number:</span>
                                        <span class="banking__account-result-desc">${account.accountNumber}</span>
                                    </div>
                                    <div class="banking__account-result-detail">
                                        <span class="banking__account-result-title">Balance (VND):</span>
                                        <span class="banking__account-result-desc">
                                            <fmt:formatNumber type="number" value="${account.balance}" pattern="###,###"/>
                                        </span>
                                    </div>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div class="banking__account-result display-flex">
                                    <h3 class="banking__account-result-notification">Enter your account number to check information</h3>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>

                <div class="banking__account-history">
                    <h3 class="banking__account-history-heading">transaction history</h3>
                    <c:if test="${account != null}">
                        <table class="table-minimal-type banking__account-history-table">
                            <thead>
                            <tr>
                                <th>description</th>
                                <th>amount (VND)</th>
                                <th>transaction date</th>
                            </tr>
                            </thead>
                            <tbody>

                            <c:forEach items="${transactionHistoryList}" var="thl">
                                <c:choose>
                                    <c:when test="${thl.amount >= 0}">
                                        <tr class="banking__account-history--increase">
                                            <td>${thl.description}</td>
                                            <td>
                                                +<fmt:formatNumber type="number" value="${thl.amount}" pattern="###,###"/>
                                            </td>
                                            <td>${thl.transactionDate}</td>
                                        </tr>
                                    </c:when>
                                    <c:otherwise>
                                        <tr class="banking__account-history--decrease">
                                            <td>${thl.description}</td>
                                            <td>
                                                <fmt:formatNumber type="number" value="${thl.amount}" pattern="###,###"/>
                                            </td>
                                            <td>${thl.transactionDate}</td>
                                        </tr>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                            </tbody>
                        </table>
                    </c:if>
                </div>
            </div>
        </div>
</div>

<footer class="footer-section">
    <div class="footer-copyright">
        <div class="grid">
            <div class="footer__copyright-content">© Website Made By Khuong</div>
        </div>
    </div>
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
</body>
</html>

