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
                                            <div align="center"><a href="controler?/san/jmat/perpus/action=daftarBuku"><font color="#ff0000" size="+1">
                                                        <b>BUKU</b>
                                                    </font></a></div>
                                        </td>
                                        <td width="262">
                                            <div align="center"><b><a href="controler?/san/jmat/perpus/action=searchBuku"><font color="#ff0000" size="+1">SEARCH
                                                            BUKU</font></a></b></div>
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

                                                    <p>&nbsp;</p>
                                                </center>
                                            </form>
                                        </td>
                                        <td valign="top" width="728"><br />
                                            <table width="723" border="0" cellpadding="0" cellspacing="2" style="width: 553px; height: 62px;">
                                                <tbody>
                                                    <tr>
                                                        <td align="center" valign="top" width="719"><font style="color: #000000;" size="+1"><br />
                                                            </font>
                                                            <div style="text-align: left;">
                                                                <table width="714" height="46" border="0">
                                                                    <tr>
                                                                        <td style="color:#000000" >
                                                                            <form method="post" action="">
                                                                                <table width="697" border="0">
                                                                                    <tr>
                                                                                        <td><strong>Judul Buku</strong></td>
                                                                                        <td><div align="center"><strong>:</strong></div></td>
                                                                                        <td>
                                                                                            <label for="textfield">${Buku.judul}</label>
                                                                                        </td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td><strong>Pengarang</strong></td>
                                                                                        <td><div align="center"><strong>:</strong></div></td>
                                                                                        <td><label for="textfield2">${Buku.pengarang}</label>
                                                                                        </td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td><strong>Penerbit</strong></td>
                                                                                        <td><div align="center"><strong>:</strong></div></td>
                                                                                        <td><label for="textfield3">${Buku.penerbit}</label>
                                                                                        </td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td><strong>Tahun Terbit</strong></td>
                                                                                        <td><div align="center"><strong>:</strong></div></td>
                                                                                        <td><label for="textfield4">${Buku.tahunTerbit}</label></td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td width="113"><strong>Kategori Buku</strong></td>
                                                                                        <td width="9"><div align="center"><strong>:</strong></div></td>
                                                                                        <td width="561">${Buku.kategoriBuku.nama}</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td width="113"><strong>Jumlah Stok</strong></td>
                                                                                        <td width="9"><div align="center"><strong>:</strong></div></td>
                                                                                        <td width="561">${Buku.jumlahStok}</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td><strong>Jumlah Tersedia</strong></td>
                                                                                        <td><div align="center"><strong>:</strong></div></td>
                                                                                        <td>${Buku.jumlahTersedia}</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td><strong>Keterangan</strong></td>
                                                                                        <td><div align="center"><strong>:</strong></div></td>
                                                                                        <td></td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td><strong></strong></td>
                                                                                        <td></td>
                                                                                        <td>${Buku.keterangan}</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td><strong>Sinopsis</strong></td>
                                                                                        <td><div align="center"><strong>:</strong></div></td>
                                                                                        <td></td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td><strong></strong></td>
                                                                                        <td></td>
                                                                                        <td>${Buku.sinopsis}</td>
                                                                                    </tr>
                                                                                </table>
                                                                                <p align="center">&nbsp;</p>
                                                                            </form></td>
                                                                    </tr>
                                                                    <san:forEach items="${bukuAll}" var="buku">                                                                    </san:forEach>
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