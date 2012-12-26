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
                                                                            <td style="color:#FF0" align="center">
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
                                                        <td align="center" valign="top" width="719"><font style="color: #000000;" size="+1">CARI BUKU<br />
                                                            </font>
                                                            <div style="text-align: left;">
                                                                <table width="714" height="46" border="0">
                                                                    <tr>
                                                                        <td style="color:#000000" >
                                                                            <form method="post" action="controler?/san/jmat/perpus/action=hasilSearchBuku">
                                                                                <table width="315" border="0">
                                                                                    <tr>
                                                                                        <td><font color="red">*</font><strong>Judul &nbsp;&nbsp;Buku</strong></td>
                                                                                        <td><div align="center"><strong>:</strong></div></td>
                                                                                        <td>
                                                                                            <label for="textfield"></label>

                                                                                            <label for="textfield2"></label>
                                                                                            <input type="text" name="judulBuku" id="textfield2" size="30"/>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td><font color="red">*</font><strong>Pengarang</strong></td>
                                                                                        <td><div align="center"><strong>:</strong></div></td>
                                                                                        <td><label for="textfield2"></label>
                                                                                            <input type="text" name="pengarang" id="textfield2" size="30" /></td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td><strong>Penerbit</strong></td>
                                                                                        <td><div align="center"><strong>:</strong></div></td>
                                                                                        <td><label for="textfield3"></label>
                                                                                            <input type="text" name="penerbit" id="textfield3" size="30"/></td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td><strong>Tahun Terbit</strong></td>
                                                                                        <td><div align="center"><strong>:</strong></div></td>
                                                                                        <td><label for="textfield4"></label>
                                                                                            <input type="text" name="tahunTerbit" id="textfield4" size="15"/></td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td width="114">&nbsp;</td>
                                                                                        <td width="10">&nbsp;</td>
                                                                                        <td width="180"><input type="submit" name="button" id="button" value="Search" /></td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td colspan="3">Keterangan <font color="red">*</font> Wajib diisi</td>
                                                                                    </tr
                                                                                    <tr>
                                                                                        <td colspan="3"><font color="red">${msg}</font></td>
                                                                                    </tr>
                                                                                </table>
                                                                                <p align="center">&nbsp;</p>
                                                                            </form></td>
                                                                    </tr>

                                                                </table>
                                                        </td>
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

    </body>
</html>