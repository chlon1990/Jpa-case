package com.example.demo.entity;

public enum CoachType {
	SBS(0, "Side-By-Side", "SS", false, false, false),
	DFM(1, "DFM", "DFM", true, true, true),
	DCP(2, "DCP", "DCP", true, true, false),
	VXIDEVELOPMENTAL(3, "VXI Developmental", "VD", true, true, true),
	WEEKLYGOALSETTING(4, "Weekly Goal Setting", "WGS", true, true, true),
	ACCOUNTABILITYCONVERSATION(5, "Accountability Conversation", "AAC", true, true, true),
	SETTINGEXPECTATIONS(6, "Setting Expectations", "SE", true, true, true),
	SKILLTRANSFER(7, "Skill Transfer", "ST", true, true, true),
	QUALITYASSURANCE(8, "Quality Assurance", "QA", true, true, false),
	WEEKLYAGENTPERFORMANCEREVIEW(9, "Weekly Agent Performance Review", "WAPR", true, true, false),
	CARECOMMITMENTFORM(10, "Care Commitment", "CC", true, true, false),
	SBSCOACH(11, "Retention Side-By-Side", "SBS", true, true, false),
	ATTOBSERVATION(12, "AT&T Observation", "ATOB", true, true, false),
	CEIC(13, "Customer Experience Improvement Calibration", "CEIC", true, true, true),
	ACCESSOBSERVATION(14, "Access Observation", "ACOB", true, true, false),
	SAMC(15, "Strategic Alignment Meeting Process Confirmation", "SAMC", false, true, true),
	CRPC(16, "Coaching Rhythm Process Confirmation", "CRPC", false, true, false),
	AHPC(17, "Agent Huddle Process Confirmation", "AHPC", false, true, true),
	LHPC(18, "Leadership Huddle Process Confirmation", "LHPC", false, true, true),
	LAPC(19, "Leadership Academy Process Confirmation", "LAPC", false, true, false),
	COMMENDATION(20, "Commendation", "CMDT", true, true, true),
	TRILEVELFORM(21, "Tri-Level Form", "TRLF", false, true, false),
	WPR(22, "ISM Agent Weekly Performance Review (WPR)", "WPR", true, false, false),
	CBC(23, "Customer Before Company", "CBC", true, false, false),
	CMCF(24, "CE Monitoring and Coaching Form", "CMCF", true, false, true),
	MCOC(25, "Manager Coaching Observation Checklist", "MCOC", false, true, false),
	DSCF(26, "Direct Sales QA/Coaching Form", "DSCF", true, false, false),
	SQHF(27, "Sales Quick Hit Form", "SQHF", true, false, false),
	SWPR(28, "Sales Weekly Performance Review Form", "SWPR", true, true, false),
	STLF(29, "Sales Tri-Level Form", "STLF", false, true, false),
	SMPR(30, "Sales Monthly Performance Review Form", "SMPR", true, true, false),
	OOCL(31, "1:1 Coaching Loop", "OOCL", false, true, false),
	GSM(32, "Goal Setting MAP", "GSM", false, true, false),
	THPC(33, "Team Huddle Process Confirmation Form", "THPC", true, true, false),
	SACF(34, "Sustainability and Confirmation Form", "SACF", false, true, false),
	DTVS(35, "Detractor / Less Than Very Satisfied Coaching", "DTVS", true, true, false),
	GSPN(36, "Goal Setting Plan and Notes Form", "GSPN", true, true, false),
	HLPN(37, "HOT LAPS Plan and Notes Form", "HLPN", true, true, false),
	LPQM(38, "Living the Promise QA Monitoring and Coaching Form", "LPQM", true, false, false),
	SSSB(39, "Sales Support Side-By-Side Form", "SSSB", true, false, false),
	PCGF(40, "The Promise Coaching Guide Form", "PCGF", true, true, false),
	VO6C(41, "VO6 Certification Form", "VO6C", true, false, false),
	POFC(42, "Promise Observation Form", "POFC", true, false, false),
	BHCF(43, "Behavior Coaching Form", "BHCF", true, false, false),
	PFCF(44, "Performance Coaching Form", "PFCF", true, false, false),
	UFFC(45, "Promise Form", "UFFC", true, true, true),
	PDDF(46, "Performance Discussion & Development Form", "PDDF", true, true, true),
	CLPC(47, "Coaching Loop Process Confirmation", "CLPC", true, true, true),
	DMFP(48, "Direct Model Feedback Process Confirmation", "DMFP", true, true, true),
	MGPC(49, "Meet & Greet GTNK Process Confirmation", "MGPC", true, true, true),
	VOCF(50, "VoC Form", "VOCF", true, true, true),
	MGSA(51, "Monthly Goal Setting - Agent", "MGSA", true, true, true),
	MGSS(52, "Monthly Goal Setting - Supervisor", "MGSS", false, true, true),
	PFSP(53, "Plan For Success Process Confirmation", "PFSP", false, true, true),
	MGSC(54, "Monthly Goal Setting - Agent Process Confirmation", "MGSC", false, true, true),
	MGSL(55, "Monthly Goal Setting - Leader Process Confirmation", "MGSL", false, true, true),
	OFPC(56, "On the Fly Process Confirmation", "OFPC", false, true, true),
	RFPC(57, "Rapid Fire Process Confirmation", "RFPC", false, true, true),
	HLPC(58, "Hot Lap Process Confirmation", "HLPC", false, true, true),
	PFMD(59, "Performance Daily Coaching", "PFMD", true, true, false),
	PPCF(60, "Coaching Form - Revised", "PPCF", false, true, false),
	DSCC(61, "Direct Sales CenturyLink Coaching Form", "DSCC", true, true, false),
	TRCT(62, "Triad Coaching Tool", "TRCT", true, true, false),
	CASO(63, "CON ACQ SBS Observation Form", "CASO", true, true, false),
	DDDM(64, "Data Drive Decision Making (DDDM) Process Confirmation", "DDDM", false, true, false),
	SSPC(65, "Side By Side Process Confirmation", "SSPC", false, true, false),
	ICWT(66, "ICHYWT Form", "ICWT", true, false, false),
	CSLP(67, "Close Loop Form", "CSLP", false, true, false),
	HCLF(68, "Huddle Confirmation Loop Form", "HCLF", false, true, false),
	TDDM(69, "DDDM Form", "TDDM", false, true, false),
	OFSF(70, "Offer Strength Form", "OFSF", true, true, false),
	CCAP(71, "Call Center Action Plan", "CCAP", true, true, false),
	ATDC(72, "Attendance Coaching", "ATDC", true, false, false),
	ATAC(73, "Attendance Accountability", "ATAC", true, false, false),
	PCIC(74, "PCI", "PCIC", true, false, false),
	PCIA(75, "PCI Accountability", "PCIA", true, false, false),
	MOFF(76, "Management Observation Feedback Form", "MOFF", false, true, false),
	PTDP(77, "PEP Talk Developmental Plan Form", "PTDP", false, true, false),
	OSPF(78, "One Stop Process Form", "OSPF", true, true, false),
    OTHR(79, "Other","OTHR",true,false,false),
    PCFU(80, "Performance Coaching Form","PCFU",true,false,false),
    DEVC(81, "Developmental Coaching","DEVC",true,true,false),
    SCL(82, "Simplified Coaching Loop","SCL",false,true,false),
    SDDDM(83, "Simplified DDDM","SDDDM",false,true,false),
    SH(84, "Simplified Huddle","SH",false,true,false),
	TSCF(85, "Training Simulator Coaching Form","TSCF",true,false,false),
	TMCF(86, "Teammate Coaching Form", "TMCF", true, true, false),
	TDCF(87, "Triad Coaching Form", "TDCF", false, true, false),
	UVDF(88, "UNIFIED VOC DDA Form", "UVDF", true, false, true),
	TPCF(89, "The Promise Coaching Form 2.0 (Sales)", "TPCF", true, false, true),
	TPCN(90, "The Promise Coaching Form 2.0 (No Sales)", "TPCN", true, false, true),
	UVDF2(91, "VOC DETRACTOR Form", "UVDF2", true, false, true),
	DTCF(92, "DETRACTOR COACHING", "DTCF", true, true, false),
	QCCO(93, "QA CRITICAL CALL-OUT COACHING", "QCCO", true, true, false),
	TFSC(94, "TFS COACHING", "TFSC", true, true, false),
	GENERAL(95, "GENERAL COACHING", "GENERAL", true, true, false),
	OMGS(96,"OM GS", "OMGS", true, true, false),
	VDFU(97,"VOC Detractor Follow Up Form", "VDFU", true, false, true),
	CDFU(98," Coaching & Developmental/Follow-up Form", "CDFU", true, true, false),
	AGSF(99," Agent Goal Setting Form", "AGSF", true, true, false),
	SMART(100,"SMARTGoals", "SMART", true, true, false),

    ALL(-1, "", "", true, true, false);

    private int type;

    private String name;

    private String abbr;

    private boolean isCoaching;

    private boolean isTriadCoaching;

    private boolean enableExport;

    private CoachType(int type, String name, String abbr, boolean isCoaching, boolean isTriadCoaching,
            boolean enableExport) {
        this.type = type;
        this.abbr = abbr;
        this.name = name;
        this.isCoaching = isCoaching;
        this.isTriadCoaching = isTriadCoaching;
        this.enableExport = enableExport;
    }

    public int getValue() {
        return this.type;
    }

    public static CoachType valueOf(int ordinal) {
        if (ordinal < 0 || ordinal >= values().length) {
            throw new IndexOutOfBoundsException("Invalid ordinal");
        }
        return values()[ordinal];
    }

    public static CoachType getByAbbr(String abbr) {
        for (CoachType c : CoachType.values()) {
            if (c.getAbbr().equals(abbr)) {
                return c;
            }
        }
        return null;
    }

    public String getAbbr() {
        return this.abbr;
    }

    public String getName() {
        return this.name;
    }

    public boolean isCoaching() {
        return this.isCoaching;
    }

    public boolean isTriadCoaching() {
        return this.isTriadCoaching;
    }

    public boolean enableExport() {
        return this.enableExport;
    }
}
