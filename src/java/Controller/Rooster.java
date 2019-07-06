/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DosenDAO;
import DAO.JadwalDAO;
import DAO.KelasDAO;
import DAO.Mata_KuliahDAO;
import DAO.RuanganDAO;
import Model.Dosen;
import Model.Jadwal;
import Model.Kelas;
import Model.Mata_Kuliah;
import Model.Ruangan;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kivla
 */
@WebServlet(name = "Rooster", urlPatterns = {"/Rooster","/edit","/delete","/searchDsn","/searchAjr","/searchRankAjr"} )
public class Rooster extends HttpServlet {
    private static final long serialVersionUID = 1L;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Rooster</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Rooster at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String act = request.getServletPath();
        try{
            switch(act){
                case "/edit":{
                    editForm(request, response);
                    break;
                }
                case "/delete":{
                    deleteData(request, response);
                    break;
                }
                case "/searchDsn":{
                    displayjadwaldsn(request,response);
                    break;
                }
                case "/searchAjr":{
                    displayjamdsn(request,response);
                    break;
                }
                case "/searchRankAjr":{
                    displayjamsort(request,response);
                    break;
                }
            }
        }  catch (SQLException | ParseException ex) {
            Logger.getLogger(Rooster.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String action = request.getParameter("action");
        switch (action){
            case "allschedule":{
                try {
                        displaySchedule(request, response);
                } catch (SQLException | ParseException ex) {
                        Logger.getLogger(Rooster.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case "dosen":{
                try {
                        displaydosen(request, response);
                } catch (SQLException | ParseException ex) {
                        Logger.getLogger(Rooster.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case "matkul":{
                try {
                        displaymatkul(request, response);
                } catch (SQLException | ParseException ex) {
                        Logger.getLogger(Rooster.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case "ruangan":{
                try {
                        displayruangan(request, response);
                } catch (SQLException | ParseException ex) {
                        Logger.getLogger(Rooster.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case "kelas":{
                try {
                        displaykelas(request, response);
                } catch (SQLException | ParseException ex) {
                        Logger.getLogger(Rooster.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
//            case "jadwaldsn":{
//                try{
//                        displayjadwaldsn(request,response);
//                } catch (SQLException | ParseException ex) {
//                Logger.getLogger(Rooster.class.getName()).log(Level.SEVERE, null, ex);
//            }
//                break;
//            }
        }
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "inp_dosen":{
                try {
                        savedosen(request, response);
                } catch (SQLException | ParseException ex) {
                        Logger.getLogger(Rooster.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case "inp_jadwal":{
                try {
                        savejadwal(request, response);
                } catch (SQLException | ParseException ex) {
                        Logger.getLogger(Rooster.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case "inp_matkul":{
                try {
                        savematkul(request, response);
                } catch (SQLException | ParseException ex) {
                        Logger.getLogger(Rooster.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case "upd_jadwal":{
                try {
                        updtjadwal(request, response);
                } catch (SQLException | ParseException ex) {
                        Logger.getLogger(Rooster.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
        }
    }

    public void displaySchedule(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException, ParseException, ServletException{
        
        List<Jadwal> jadwal = JadwalDAO.getAll();
        request.setAttribute("jadwal", jadwal);
    }
    
    public void displaydosen(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException, ParseException, ServletException{
        
        List<Dosen> dosen = DosenDAO.getAll();
        request.setAttribute("dosen", dosen);
    }
    
    public void displaymatkul(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException, ParseException, ServletException{
        
        List<Mata_Kuliah> matkul = Mata_KuliahDAO.getAll();
        request.setAttribute("matkul", matkul);
    }
    
    public void displayruangan(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException, ParseException, ServletException{
        
        List<Ruangan> ruangan = RuanganDAO.getAll();
        request.setAttribute("ruangan", ruangan);
    }
    
    public void displaykelas(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException, ParseException, ServletException{
        
        List<Kelas> kelas = KelasDAO.getAll();
        request.setAttribute("kelas", kelas);
    }
    
    public void displayprodi(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException, ParseException, ServletException{
        
        List<Kelas> kelas = KelasDAO.getAll();
        request.setAttribute("kelas", kelas);
    }
    
    public void displayjadwaldsn(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException, ParseException, ServletException{
        String kd_dosen = request.getParameter("JadwalDosen");
        
        List<Jadwal> jadwal = JadwalDAO.getJdwDosen(kd_dosen);
        RequestDispatcher dispatcher = request.getRequestDispatcher("searchtable.jsp");
        request.setAttribute("jadwal", jadwal);
        dispatcher.forward(request, response);
    }
    
    public void displayjamsort(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException, ParseException, ServletException{
        int limit = Integer.parseInt(request.getParameter("Limit"));
        
        List<JamDosen> jadwal = JadwalDAO.getRankDsn(limit);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("searchtable.jsp");
        request.setAttribute("jadwal", jadwal);
        dispatcher.forward(request, response);
    }
    
    public void displayjamdsn(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException, ParseException, ServletException{
        String kd_dosen = request.getParameter("JamDosen");
        
        int waktu = JadwalDAO.getWktDosen(kd_dosen);
        
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<script type=\"text/javascript\">");  
        out.println("alert('Jumlah Jam Ajar Dosen " + kd_dosen + " : " + waktu + "');");  
        out.println("location='./index.jsp';");
        out.println("</script>");
    }
    
    public void deleteData(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException, ParseException, ServletException{
        
        String kd_dosen = request.getParameter("kd_dosen");
        String kd_matkul = request.getParameter("kd_matkul");
        String kd_ruangan = request.getParameter("kd_ruangan");
        String nama_kelas = request.getParameter("nama_kelas");
        String prodi = request.getParameter("prodi");
        String kd_jam = request.getParameter("kd_jam");
        
        int stat = JadwalDAO.delete(kd_dosen, kd_matkul, kd_ruangan, nama_kelas, prodi, Integer.parseInt(kd_jam));
        
        PrintWriter out = response.getWriter();
        response.setContentType("text/html"); 
        
        if (stat == 1){
            out.println("<script type=\"text/javascript\">");  
            out.println("alert('Data Berhasil di Hapus!');");  
            out.println("location='./delete.jsp';");
            out.println("</script>");
        } else {
            out.println("<script type=\"text/javascript\">");  
            out.println("alert('Data tidak berhasil diHapus!');");  
            out.println("location='./delete.jsp';");
            out.println("</script>");
        }
    }
    
    public void savedosen(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException, ParseException, ServletException{
        
        Dosen dosen = new Dosen();
        
        String kd_dosen = request.getParameter("kd_dosen");
        String nm_dosen = request.getParameter("nm_dosen");
        
        dosen.setKD_DOSEN(kd_dosen);
        dosen.setNAMA_DOSEN(nm_dosen);
        
        int stat = DosenDAO.save(dosen);
        PrintWriter out = response.getWriter();
        response.setContentType("text/html"); 
        
        if (stat == 1){
            out.println("<script type=\"text/javascript\">");  
            out.println("alert('Data Berhasil di simpan!');");  
            out.println("location='./input.jsp';");
            out.println("</script>");
        } else {
            out.println("<script type=\"text/javascript\">");  
            out.println("alert('Data tidak berhasil disimpan!');");  
            out.println("location='./input.jsp';");
            out.println("</script>");
        }
    }
    
    String kd_dsen;
    String kd_mtkul;
    String kd_rngan;
    String nama_klas;
    String prdi;
    String kd_jm;
    
    private void editForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        //int id = Integer.parseInt(request.getParameter("id"));
        //this.id = request.getParameterValues("id");
        //Jadwal jadwal = JadwalDAO.getJadwal(id[0], id[1], id[2], id[3], id[4], Integer.parseInt(id[5]));
        this.kd_dsen = request.getParameter("kd_dosen");
        this.kd_mtkul = request.getParameter("kd_matkul");
        this.kd_rngan = request.getParameter("kd_ruangan");
        this.nama_klas = request.getParameter("nama_kelas");
        this.prdi = request.getParameter("prodi");
        this.kd_jm = request.getParameter("kd_jam");
        
        Jadwal jadwal = JadwalDAO.getJadwal(kd_dsen, kd_mtkul, kd_rngan, nama_klas, prdi, Integer.parseInt(kd_jm));
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("editForm.jsp");
        request.setAttribute("jadwal", jadwal);
        dispatcher.forward(request, response);
 
    }
    
    public void savejadwal(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException, ParseException, ServletException{
        int stat = 0;
        
        Jadwal jadwal = new Jadwal();
        
        String kd_dosen = request.getParameter("kode_dsn");
        String kd_matkul = request.getParameter("matkul");
        String kd_ruangan = request.getParameter("ruangan");
        String nama_kelas = request.getParameter("kelas");
        String prodi = request.getParameter("prodi");
        String waktu[] = request.getParameterValues("waktu");
        String hari = request.getParameter("hari");
        String tahun_ajar = request.getParameter("tahunajar");
        String semester = request.getParameter("semester");
        
        for(int i = 0; i < waktu.length; i++){
            jadwal.setKD_DOSEN(kd_dosen);
            jadwal.setKD_MATKUL(kd_matkul);
            jadwal.setKD_RUANGAN(kd_ruangan);
            jadwal.setNAMA_KELAS(nama_kelas);
            jadwal.setPRODI(prodi);
            jadwal.setKD_JAM(Integer.parseInt(waktu[i]));
            jadwal.setHARI(hari);
            jadwal.setTAHUN_AJARAN(tahun_ajar);
            jadwal.setSEMESTER(semester);
            
            stat = JadwalDAO.save(jadwal);
        }
        
        //int stat = JadwalDAO.save(jadwal);
        PrintWriter out = response.getWriter();
        response.setContentType("text/html"); 
        
        if (stat == 1){
            out.println("<script type=\"text/javascript\">");  
            out.println("alert('Data Berhasil di simpan!');");  
            out.println("location='./input.jsp';");
            out.println("</script>");
        } else {
            out.println("<script type=\"text/javascript\">");  
            out.println("alert('Data tidak berhasil disimpan!');");  
            out.println("location='./input.jsp';");
            out.println("</script>");
        }
    }
    
    public void updtjadwal(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException, ParseException, ServletException{
        int stat = 0;
        
        Jadwal jadwal = new Jadwal();
        
        String kd_dosen = request.getParameter("kode_dsn");
        String kd_matkul = request.getParameter("matkul");
        String kd_ruangan = request.getParameter("ruangan");
        String nama_kelas = request.getParameter("kelas");
        String prodi = request.getParameter("prodi");
        String waktu = request.getParameter("waktu");
        String hari = request.getParameter("hari");
        String tahun_ajar = request.getParameter("tahunajar");
        String semester = request.getParameter("semester");
        
        jadwal.setKD_DOSEN(kd_dosen);
        jadwal.setKD_MATKUL(kd_matkul);
        jadwal.setKD_RUANGAN(kd_ruangan);
        jadwal.setNAMA_KELAS(nama_kelas);
        jadwal.setPRODI(prodi);
        jadwal.setKD_JAM(Integer.parseInt(waktu));
        jadwal.setHARI(hari);
        jadwal.setTAHUN_AJARAN(tahun_ajar);
        jadwal.setSEMESTER(semester);

        stat = JadwalDAO.update(jadwal,this.kd_dsen, this.kd_mtkul, this.kd_rngan, this.nama_klas, this.prdi, Integer.parseInt(this.kd_jm));
        
        
        //int stat = JadwalDAO.save(jadwal);
        PrintWriter out = response.getWriter();
        response.setContentType("text/html"); 
        
        if (stat == 1){
            out.println("<script type=\"text/javascript\">");  
            out.println("alert('Data Berhasil di Update!');");  
            out.println("location='./edit.jsp';");
            out.println("</script>");
        } else {
            out.println("<script type=\"text/javascript\">");  
            out.println("alert('Data tidak berhasil di Update!');");  
            out.println("location='./edit.jsp';");
            out.println("</script>");
        }
    }
    
    public void savematkul(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException, ParseException, ServletException{
        
        Mata_Kuliah matkul = new Mata_Kuliah();
        
        String kd_matkul = request.getParameter("kd_matkul");
        String nm_matkul = request.getParameter("nm_matkul");
        String sks = request.getParameter("sks");
        
        matkul.setKD_MATKUL(kd_matkul);
        matkul.setNAMA_MATKUL(nm_matkul);
        matkul.setSKS(Integer.parseInt(sks));
        
        int stat = Mata_KuliahDAO.save(matkul);
        PrintWriter out = response.getWriter();
        response.setContentType("text/html"); 
        
        if (stat == 1){
            out.println("<script type=\"text/javascript\">");  
            out.println("alert('Data Berhasil di simpan!');");  
            out.println("location='./input.jsp';");
            out.println("</script>");
        } else {
            out.println("<script type=\"text/javascript\">");  
            out.println("alert('Data tidak berhasil disimpan!');");  
            out.println("location='./input.jsp';");
            out.println("</script>");
        }
    }
    
    public class JamDosen{
        
        private String kd_dosen;
        private String nm_dosen;
        private int jml_ajar;
        /**
         * @return the kd_dosen
         */
        public String getKd_dosen() {
            return kd_dosen;
        }

        /**
         * @param kd_dosen the kd_dosen to set
         */
        public void setKd_dosen(String kd_dosen) {
            this.kd_dosen = kd_dosen;
        }

        /**
         * @return the nm_dosen
         */
        public String getNm_dosen() {
            return nm_dosen;
        }

        /**
         * @param nm_dosen the nm_dosen to set
         */
        public void setNm_dosen(String nm_dosen) {
            this.nm_dosen = nm_dosen;
        }

        /**
         * @return the jml_ajar
         */
        public int getJml_ajar() {
            return jml_ajar;
        }

        /**
         * @param jml_ajar the jml_ajar to set
         */
        public void setJml_ajar(int jml_ajar) {
            this.jml_ajar = jml_ajar;
        }
    }
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
