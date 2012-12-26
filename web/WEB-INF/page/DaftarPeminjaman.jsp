<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="san" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
                                        <td width="231">
                                            <div align="center"> 
                                                <a href="controler?/san/jmat/perpus/action=homeAdmin"><font color="#ff0000" size="+1">
                                                        <b>HOME</b>
                                                    </font></a></div>
                                        </td>
                                        <td width="191"><div align="center"><a href="controler?/san/jmat/perpus/action=daftarAnggota"><b><font color="#ff0000" size="+1">ANGGOTA</font></b></a></div></td>
                                        <td width="171"><div align="center"><a href="controler?/san/jmat/perpus/action=daftarPeminjaman"><b><font color="#ff0000" size="+1">TRANSAKSI</font></b></a></div></td>
                                        <td width="122">
                                            <div align="center"> 
                                                <a href="controler?/san/jmat/perpus/action=daftarBukuAdmin"><font color="#ff0000" size="+1">
                                                        <b>BUKU</b>
                                                    </font></a></div>
                                        </td>
                                        <td width="250">
                                            <div align="center"><a href="controler?/san/jmat/perpus/action=daftarPengembalian"><b><font color="#ff0000" size="+1">MANAGER MENU</font></b></a></div>
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
                                        <td height="280" valign="top" width="222">
                                            <form id="form1" name="form1" method="post" action="">
                                                <center>
                                                    <p>&nbsp;</p>
                                                    <p>&nbsp;</p>
                                                    <table width="209" height="109" border="1">
                                                        <tr>
                                                            <td width="218">
                                                                <table width="196" height="30" border="0" style="background-color: rgb(102, 102, 102);">
                                                                    <tr>
                                                                        <td width="190" style="color:#FFFF00"><div align="center"><font 
                                                                                    size="+1" style="color: #FFFF00"><b>CATEGORY TRANSAKSI</b>
                                                                                </font></div></td>
                                                                    </tr>

                                                                    <tr>
                                                                        <td style="color:#FFFF00" align="center"><a href="controler?/san/jmat/perpus/action=peminjamanBuku"><p><b><font color="#FFFF00">PEMINJAMAN</font></b></p></a>
                                                                            
                                                                    </tr>
                                                                    
                                                                </table>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                    <p>&nbsp;</p>
                                                    <p>&nbsp;</p>
                                                </center>
                                            </form>
                                        </td>
                                        <td valign="top" width="763"><br />
                                            <table width="723" border="0" cellpadding="0" cellspacing="2" style="width: 553px; height: 62px;">
                                                <tbody>
                                                    <tr>
                                                        <td align="center" valign="top" width="719"><font style="color: #000000;" size="+1">DAFTAR PEMINJAMAN<br />
                                                            </font>
                                                            <div style="text-align: left;">
                                                                <table width="755" height="210" border="1">
                                                                    <form id="form2" name="form2" method="post" action="controler?/san/jmat/perpus/action=searchDaftarPeminjaman">
                                                                        <san:if test="${msg2!=null}">
                                                                            <tr>
                                                                                <td colspan="5" style="color: red"><div align="center"><b>${msg2}</b></div></td>
                                                                            </tr>
                                                                        </san:if>

                                                                        <tr>
                                                                            <td colspan="5" style="color:#000000" align="center"><label for="textfield"></label>
                                                                                <input type="text" name="filter" id="textfield" size="50" />
                                                                                <input type="submit" name="button" id="button" value="Search" />
                                                                            </td>
                                                                        </tr>
                                                                    </form>
                                                                    <tr>
                                                                        <td height="43" style="color:#000000" ><div align="center">NOMOR ANGGOTA</div></td>
                                                                        <td style="color:#000000"><div align="center">TANGGAL PINJAM</div></td>
                                                                        <td style="color:#000000"><div align="center">TANGGAL KEMBALI</div></td>
                                                                        <td style="color:#000000"><div align="center">BUKU YANG DIPINJAM</div></td>
                                                                        <td style="color:#000000"><div align="center">KEMBALIKAN BUKU</div></td>
                                                                    </tr>
                                                                    <san:if test="${msg==null}">
                                                                        <san:forEach items="${peminjaman}" var="pmj">
                                                                            <tr>
                                                                                <td width="133" style="color:#000000" ><div align="left">${pmj.nomorAnggota}</div></td>
                                                                                <td width="128" style="color:#000000"><div align="center"><fmt:formatDate value="${pmj.tanggalPinjam}" type="date" /></div></td>
                                                                                <td width="140" style="color:#000000"><div align="center"><fmt:formatDate value="${pmj.tanggalHarusKembali}" type="date" /></div></td>
                                                                                <td width="202" style="color: #000000"><div align="left">${pmj.judulBuku}</div></td>
                                                                                <td width="118" style="color:#000000"><div align="center"><a href="controler?/san/jmat/perpus/action=pengembalianBuku&idPeminjam=${pmj.idPeminjaman}">YES</a></div></td>
                                                                            </tr>
                                                                        </san:forEach>
                                                                        <tr>
                                                                            <td colspan="4" style="color:#0000FF" ><div align="center"><strong>TOTAL BUKU YANG DIPINJAM</strong></div></td>
                                                                            <td style="color:#000000"><div align="center">${jumlah}</div></td>
                                                                        </tr>

                                                                    </san:if>
                                                                    <san:if test="${msg!=null}">
                                                                        <tr>
                                                                            <td colspan="5" style="color: firebrick" ><div align="center">${msg}</div></td>
                                                                        </tr>
                                                                    </san:if>
                                                                </table>

                                                            </div>
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