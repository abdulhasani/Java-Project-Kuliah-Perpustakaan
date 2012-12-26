<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="san" %>
<html xmlns="http://www.w3.org/1999/xhtml"><head>



        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><title>Perpustakaan Smart</title>
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
    </head>
    <body>
        
            <center>
            <marquee behavior="scroll" direction="left"><font face="Arial Black, Gadget, sans-serif" size="+3">SELAMAT DATANG
                    DIPERPUSTAKAAN SMART</font></marquee>
            <img src="img/perpustakaan.jpg" width="1032" height="233" border="1" align="top" style="width: 1005px; height: 213px;" /><br />
            <table width="1127" border="0" bgcolor="#EFEFEF" style="width: 1007px; height: 254px;">
                <!--MENU--> <tbody>
                    <tr valign="top">
                        <td align="left" height="28" width="1121">
                            <table style="width: 999px; height: 35px; background-color: rgb(102, 102, 102);" border="1">
                                <tbody>
                                    <tr valign="top">
                                        <td width="259">
                                            <div align="center"> 
                                                <a href="controler?/san/jmat/perpus/action=home"><font color="#ff0000" size="+1">
                                                        <b>HOME</b>
                                                    </font></a></div>
                                        </td>
                                        <td width="321">
                                            <div align="center"> 
                                                <a href="controler?/san/jmat/perpus/action=daftarBuku"><font color="#ff0000" size="+1">
                                                        <b>BUKU</b>
                                                    </font></a></div>
                                        </td>
                                        <td width="262">
                                            <div align="center">
                                                <a href="controler?/san/jmat/perpus/action=searchBuku"><b><font color="#ff0000" size="+1">SEARCH
                                                            BUKU</font></b></a>
                                            </div>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </td>
                    </tr>
                    <tr>
                    </tr>
                    <tr valign="top">
                        <td height="161">
                            <table width="1113" border="0" cellpadding="1" cellspacing="2" style="width: 995px; height: 201px;">
                                <tbody>
                                    <tr>
                                        <td height="280" valign="top" width="257">
                                            <form id="form1" name="form1" method="post" action="">
                                                <center>
                                                    <p>&nbsp;</p>
                                                    <table width="230" height="109" border="1">
                                                        <tr>
                                                            <td>
                                                                <table width="222" height="30" border="0" style="background-color: rgb(102, 102, 102);">
                                                                    <tr>
                                                                        <td style="color:#FFFF00"><div align="center"><font 
                                                                                    size="+1" style="color: #FFFF00"><b>CATEGORY BUKU</b>
                                                                                    </font></div></td>
                                                                    </tr>
                                                                    <san:forEach items="${categorys}" var="cat">    
                                                                        <tr>
                                                                            <td style="color:#FFFF00" align="center">
                                                                                <b><a href="controler?/san/jmat/perpus/action=filterBuku&katId=${cat.idKategoriBuku}"><font color="#FFFF00">${cat.nama}</font></a></b>
                                                                            </td>
                                                                        </tr>
                                                                    </san:forEach>
                                                                </table>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                    <p>&nbsp;</p>
                                                    <p>&nbsp;</p>
                                                </center>
                                            </form>
                                        </td>
                                        <td valign="top" width="728"><br />
                                            <table width="723" border="0" cellpadding="0" cellspacing="2" style="width: 553px; height: 62px;">
                                                <tbody>
                                                    <tr>
                                                        <td align="center" valign="top" width="719"><font style="color: #000000;" size="+1">DAFTAR BUKU<br />
                                                            </font>
                                                            <div style="text-align: left;">
                                                                <table width="714" height="46" border="1">
                                                                    <tr>
                                                                        <td style="color:#000000" ><div align="center">JUDUL BUKU</div></td>
                                                                        <td style="color:#000000"><div align="center">PENGARANG</div></td>
                                                                        <td style="color:#000000"><div align="center">PENERBIT</div></td>
                                                                        <td style="color:#000000"><div align="center">TAHUN TERBIT</div></td>
                                                                        <td style="color:#000000"><div align="center">SINOPSIS</div></td>
                                                                    </tr>
                                                                    <san:forEach items="${bukuAll}" var="buku">
                                                                        <tr>
                                                                            <td width="190" style="color:#000000" ><div align="left">${buku.judul}</div></td>
                                                                            <td width="130" style="color:#000000"><div align="left">${buku.pengarang}</div></td>
                                                                            <td width="142" style="color:#000000"><div align="left">${buku.penerbit}</div></td>
                                                                            <td width="80" style="color: #000000"><div align="center">${buku.tahunTerbit}</div></td>
                                                                            <td width="119" style="color:#ffffff"><div align="center">
                                                                                    <a href="controler?/san/jmat/perpus/action=sinopsis&idBuku=${buku.idBuku}">sinopsis</a></div></td>
                                                                        </tr>
                                                                    </san:forEach>
                                                                </table>
                                                                <font style="font-family: Comic Sans MS;" color="yellow"><font style="color: yellow;" size="+1"><br />
                                                                    </font></font></div>
                                                            <font color="yellow">
                                                            </font></td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                            &nbsp;
                                            <br />
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </td>
                    </tr>
                </tbody>
            </table>
            <br />

        </center>

    </body></html>