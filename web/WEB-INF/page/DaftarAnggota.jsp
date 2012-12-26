<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="san" %>
<html xmlns="http://www.w3.org/1999/xhtml"><head>



        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Perpustakaan Smart</title>
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
                                        <td height="280" valign="top" width="228">
                                            <form id="form1" name="form1" method="post" action="">
                                                <center>
                                                    <p>&nbsp;</p>
                                                    <table width="192" height="109" border="1">
                                                        <tr>
                                                            <td width="182">
                                                                <table width="186" height="30" border="0" style="background-color: rgb(102, 102, 102);">
                                                                    <tr>
                                                                        <td width="180" style="color:#FFFF00"><div align="center">
                                                                                <a href="controler?/san/jmat/perpus/action=daftarKategoriAnggota"><font size="+1" style="color: #FFFF00"><b>CATEGORY ANGGOTA</b></font>
                                                                                </a></div></td>
                                                                    </tr>
                                                                    <san:forEach items="${ktgAnggota}" var="cat">    
                                                                        <tr>
                                                                            <td style="color:#FFFF00" align="center">
                                                                                <b><a href="controler?/san/jmat/perpus/action=filterAnggota&katId=${cat.idKategoriAnggota}"><font color="#FFFF00">${cat.nama}</font></a></b>
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
                                        <td valign="top" width="757"><br />
                                            <table width="732" border="0" cellpadding="0" cellspacing="2" style="width: 553px; height: 62px;">
                                                <tbody>
                                                    <tr>
                                                        <td align="center" valign="top" width="728"><font style="color: #000000;" size="+1">DAFTAR ANGGOTA<br />
                                                            </font>
                                                            <div style="text-align: left;">
                                                                <table width="736" height="46" border="1">
                                                                    <form id="form2" name="form2" method="post" action="controler?/san/jmat/perpus/action=searchAnggota">
                                                                        <san:if test="${msg2!=null}">
                                                                            <tr>
                                                                                <td colspan="8" style="color: red"><div align="center"><b>${msg2}</b></div></td>
                                                                            </tr>
                                                                        </san:if>
                                                                        
                                                                        <tr>
                                                                            <td style="color:#000000" align="right">Nama </td>
                                                                            <td colspan="7" style="color:#000000"><label for="textfield"></label>
                                                                                <input type="text" name="nama" id="textfield" size="35" /></td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td style="color:#000000" align="right" >Nomor Anggota</td>
                                                                            <td colspan="7" style="color:#000000"><label for="textfield2"></label>
                                                                                <input type="text" name="nomorAnggota" id="textfield2" size="35"/></td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td colspan="8" style="color:#000000" > <div align="center">

                                                                                    <input type="submit" name="button" id="button" value="Search" />

                                                                                </div></td>
                                                                        </tr>
                                                                    </form>
                                                                    <tr>
                                                                        <td style="color:#000000" ><div align="center">NOMOR ANGGOTA</div></td>
                                                                        <td style="color:#000000"><div align="center">NAMA</div></td>
                                                                        <td style="color:#000000"><div align="center">NO IDENTITAS</div></td>
                                                                        <td style="color:#000000"><div align="center">JENIS IDENTITAS</div></td>
                                                                        <td style="color:#000000"><div align="center">ALAMAT</div></td>
                                                                        <td style="color:#000000"><div align="center">KATEGORI</div></td>
                                                                        <td colspan="2"style="color:#000000"><div align="center">KETERANGAN</div></td>
                                                                    </tr>
                                                                    <san:if test="${msg==null}">
                                                                        <san:forEach items="${anggotaAll}" var="anggota">
                                                                            <tr>
                                                                                <td width="96" style="color:#000000" ><a href="controler?/san/jmat/perpus/action=crudAnggota&edit=${anggota.idAnggota}"><div align="left">${anggota.nomorAnggota}</div></a></td>
                                                                                <td width="144" style="color:#000000"><div align="left">${anggota.nama}</div></td>
                                                                                <td width="118" style="color:#000000"><div align="left">${anggota.noIdentitas}</div></td>
                                                                                <td width="125" style="color: #000000"><div align="center">${anggota.jenisIdentitas}</div></td>
                                                                                <td width="112" style="color:#000000"><div align="left">${anggota.alamat}</div></td>
                                                                                <td width="101" style="color:#000000">${anggota.kategoriAnggota.nama}</td>
                                                                                <td width="101" style="color:#000000"><a href="controler?/san/jmat/perpus/action=viewBukuDipinjam&noAnggota=${anggota.nomorAnggota}">${anggota.keterangan}</a></td>
                                                                                <td width="101" style="color:#000000"><a href="controler?/san/jmat/perpus/action=deleteAnggota&delete=${anggota.idAnggota}"><div align="center" style="color: red">Delete</div></a></td>
                                                                            </tr>
                                                                        </san:forEach>
                                                                    </san:if>
                                                                    <san:if test="${msg!=null}">
                                                                        <tr>
                                                                            <td colspan="8" style="color: firebrick" ><div align="center">${msg}</div></td>
                                                                        </tr>
                                                                    </san:if>
                                                                    <tr>
                                                                        <td colspan="8" style="color:#000000" >
                                                                            <a href="controler?/san/jmat/perpus/action=crudAnggota"><div align="center">ADD</div></a> </td>
                                                                    </tr>


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