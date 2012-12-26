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
                                            <div align="center"><a href="controler?/san/jmat/perpus/action=home"><font color="#ff0000" size="+1">
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
                                                <a href="controler?/san/jmat/perpus/action=searchBuku"><font color="#ff0000" size="+1"><b>SEARCH
                                                            BUKU</b></font></a></div>
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
                                        <td width="728" height="280" valign="top">&nbsp;
                                            <san:if test="${msg!=null}">
                                                <div align="center"><b>${msg}</b></div>
                                                <div align="center"></div>
                                            </san:if>
                                            <form id="form1" name="form1" method="post" action="">
                                                <table width="992" border="1">
                                                    <tr>
                                                        <td width="145"><div align="center"><strong>JUDUL BUKU</strong></div></td>
                                                        <td width="132"><div align="center"><strong>PENGARANG</strong></div></td>
                                                        <td width="155"><div align="center"><strong>PENERBIT</strong></div></td>
                                                        <td width="78"><div align="center"><strong>TAHUN TERBIT</strong></div></td>
                                                        <td width="165"><div align="center"><strong>SINOPSIS</strong></div></td>
                                                        <td width="75"><div align="center"><strong>JUMLAH STOK</strong></div></td>
                                                        <td width="86"><div align="center"><strong>JUMLAH TERSEDIA</strong></div></td>
                                                        <td width="122"><div align="center"><strong>KETERANGAN</strong></div></td>
                                                    </tr>
                                                    <san:if test="${buku!=null}">
                                                        <san:forEach items="${buku}" var="bk">
                                                            <tr>
                                                                <td>${bk.judul}</td>
                                                                <td>${bk.pengarang}</td>
                                                                <td>${bk.penerbit}</td>
                                                                <td><div align="center">${bk.tahunTerbit}</div></td>
                                                                <td>${bk.sinopsis}</td>
                                                                <td><div align="center">${bk.jumlahStok}</div></td>
                                                                <td><div align="center">${bk.jumlahTersedia}</div></td>
                                                                <td><div align="center">${bk.keterangan}</div></td>
                                                            </tr>
                                                        </san:forEach>
                                                    </san:if>
                                                    <san:if test="${msg==null}">
                                                        <tr>
                                                            <td colspan="9"><center><font color="red">BUKU YANG ANDA CARI TIDAK DITEMUKAN</font></center></td>
                                                        </tr>
                                                    </san:if>

                                                </table>
                                            </form>
                                            <div align="center"></div>
                                            <div align="center"></div>
                                            <br />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td height="280" valign="top">&nbsp;</td>
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