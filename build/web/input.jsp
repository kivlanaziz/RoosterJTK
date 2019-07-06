<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Rooster JTK</title>
        <meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="style.css">
		<script type="text/javascript" src="script.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
	
        <div id="main">
            <span style="font-size:30px;cursor:pointer" onclick="openNav('inputWrapper','270px')">&#9776; Rooster JTK</span><li style="float: right;list-style: none;">Kivlan Aziz</li>
        </div>
		
        <div id="mySidenav" class="sidenav">
            <a href="javascript:void(0)" class="closebtn" onclick="closeNav('inputWrapper','0px')">&times;</a>
            <a href="index.jsp">Schedule</a>
            <a href="input.jsp">Input Data</a>
            <a href="edit.jsp">Update Data</a>
            <a href="delete.jsp">Delete Data</a>
        </div>
		
        <div id="inputWrapper">
            <div class="tab">
                <button class="tablinks" onclick="openTabs(event, 'Dosen')">Dosen</button>
                <button class="tablinks" onclick="openTabs(event, 'Jadwal')">Jadwal</button>
                <button class="tablinks" onclick="openTabs(event, 'MataKuliah')">Mata Kuliah</button>
            </div>

            <div id="Dosen" class="tabcontent">
                <h3>INPUT DATA DOSEN</h3>

                <form action="${pageContext.request.contextPath}/Rooster?action=inp_dosen" method="POST">
                    <br><br>Kode Dosen<br> 
                    <input style="width:20%;" type="text" id="kd_dosen" name="kd_dosen" placeholder="e.g: KO001N">
                    <br><br>Nama Dosen<br>
                    <input style="width:20%;" type="text" id="nm_dosen" name="nm_dosen" placeholder="e.g: Ade Chandra Nugraha, S.Si., M.T.">
                    <br><br>
                    <input type="submit" style="width:10%;">
                </form>

            </div>

            <div id="Jadwal" class="tabcontent">
                <h3>INPUT JADWAL</h3>

                <form action="${pageContext.request.contextPath}/Rooster?action=inp_jadwal" method="POST">
                    <div class="column">
                        <jsp:include page="/Rooster?action=dosen"/>
                        <br> Dosen <br>
                        <select name="kode_dsn">
                            <c:forEach items="${dosen}" var="dt">
                                <option value="${dt.getKD_DOSEN()}"><c:out value="${dt.getNAMA_DOSEN()}"/></option>
                            </c:forEach>
                        </select>
                        <jsp:include page="/Rooster?action=matkul"/>
                        <br><br> Mata Kuliah <br>
                        <select name="matkul">
                            <c:forEach items="${matkul}" var="dt">
                                <option value="${dt.getKD_MATKUL()}"><c:out value="${dt.getNAMA_MATKUL()}"/></option>
                            </c:forEach>
                        </select>
                        <jsp:include page="/Rooster?action=ruangan"/>
                        <br><br> Ruangan <br>
                        <select name="ruangan">
                            <c:forEach items="${ruangan}" var="dt">
                                <option value="${dt.getKD_RUANGAN()}"><c:out value="${dt.getKD_RUANGAN()}"/></option>
                            </c:forEach>
                        </select>
                        <jsp:include page="/Rooster?action=kelas"/>
                        <br><br> Kelas <br>
                        <select name="kelas">
                            <c:forEach items="${kelas}" var="dt">
                                <option value="${dt.getNAMA_KELAS()}"><c:out value="${dt.getNAMA_KELAS()}"/></option>
                            </c:forEach>
                        </select>
                        <jsp:include page="/Rooster?action=prodi"/>
                        <br><br> Program Studi <br>
                        <select name="prodi">
                            <c:forEach items="${kelas}" var="dt">
                                <option value="${dt.getPRODI()}"><c:out value="${dt.getPRODI()}"/></option>
                            </c:forEach>
                        </select>

                    </div>
                    <div class="column">

                        <br> Waktu Ajar (tekan Ctrl dan klik jadwal untuk memilih lebih dari satu)<br>
                        <select style="width:50%;" name="waktu" size="4" multiple>
                                <option value="1">07:00:00-07:50:00</option>
                                <option value="2">07:50:00-08:40:00</option>
                                <option value="3">08:40:00-09:30:00</option>
                                <option value="4">09:30:00-10:20:00</option>
                                <option value="5">10:40:00-11:30:00</option>
                                <option value="6">11:30:00-12:20:00</option>
                                <option value="7">13:00:00-13:50:00</option>
                                <option value="8">13:50:00-14:40:00</option>
                                <option value="9">14:40:00-15:20:00</option>
                                <option value="10">15:20:00-16:10:00</option>
                        </select>

                        <br><br> Hari <br>
                        <input style="width:30%;" type="text" id="hari" name="hari" placeholder="e.g: Senin">

                        <br><br> Tahun Ajaran <br>
                        <input style="width:30%;" type="text" id="tahunajar" name="tahunajar" placeholder="e.g: 2017/2018">

                        <br><br> Semester <br>
                        <input style="width:30%;" type="number" id="semester" name="semester" placeholder="e.g: 3">

                        <br><br>
                        <input type="submit" style="width:20%;">
                    </div>
                </form>

            </div>

            <div id="MataKuliah" class="tabcontent">
                <h3>INPUT DATA MATA KULIAH</h3>

                <form action="${pageContext.request.contextPath}/Rooster?action=inp_matkul" method="POST">
                    <br><br>Kode Mata Kuliah<br>
                    <input style="width:20%;" type="text" id="kd_matkul" name="kd_matkul" placeholder="e.g: 16TKO3014">
                    <br><br>Nama Mata Kuliah<br>
                    <input style="width:20%;" type="text" id="nm_matkul" name="nm_matkul" placeholder="e.g: Basis Data">
                    <br><br>Jumlah SKS<br>
                    <input style="width:20%;" type="number" id="sks" name="sks" placeholder="e.g: 4">
                    <br><br>
                    <input type="submit" style="width:10%;">
                </form>

            </div>

        </div>
		
    </body>
</html>