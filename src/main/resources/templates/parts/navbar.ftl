<#include "security.ftl">
<#import "login.ftl" as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">StudCity</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">

        <ul class="navbar-nav mr-auto">
            <#if user??>
            <li class="nav-item">
                <a class="nav-link" href="/main"> Student cards </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/faculties"> Faculties </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/groups"> Groups </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/dormitories"> Dormitories </a>
            </li>

            <#else>
            <li class="nav-item">
                <a class="nav-link" href="/login"> Sign in </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/registration"> Registration </a>
            </li>
            </#if>
        </ul>
        <#if user??>
        <div class="navbar-text mr-3">${name}</div>
        <@l.logout />
        </#if>
    </div>
</nav>
