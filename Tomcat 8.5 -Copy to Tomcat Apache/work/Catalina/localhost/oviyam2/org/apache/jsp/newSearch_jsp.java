/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.71
 * Generated at: 2022-01-10 14:52:33 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class newSearch_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <script type=\"text/javascript\" src=\"js/lib/moment.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/LoadLanguage.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/newSearch.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/lib/jquery-gentleSelect.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/jquery.alerts.css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/font-awesome/css/font-awesome.min.css\">\n");
      out.write("        <script type=\"text/javascript\" src=\"js/lib/jquery.alerts.js\"></script>\n");
      out.write("        <!-- <script type=\"text/javascript\" src=\"js/lib/jquery.multiselect.js\"></script>\n");
      out.write("        <link href=\"css/jquery.multiselect.css\" rel=\"stylesheet\" type=\"text/css\"> -->\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            $(document).ready(function() {\n");
      out.write("                $('button').button();\n");
      out.write("                \n");
      out.write("                let dateFormat = \"\";\n");
      out.write("                dateFormat = languages.dateFormat.toLowerCase().replace('yyyy','yy');\n");
      out.write("                $('.bdate').datepicker({ dateFormat: dateFormat});\n");
      out.write("                $('.fsdate').datepicker({ dateFormat: dateFormat});\n");
      out.write("                $('.tsdate').datepicker({ dateFormat: dateFormat});\n");
      out.write("                \n");
      out.write("                $('#");
      out.print(request.getParameter("tabName"));
      out.write("_modalities').gentleSelect({\n");
      out.write("			   		 columns: 3,\n");
      out.write("		    		 itemWidth: 20,\n");
      out.write("				     maxDisplay: 3,				    \n");
      out.write("				     prompt: \"ALL\", \n");
      out.write("		   		 });	\n");
      out.write("                //     $('#");
      out.print(request.getParameter("tabName"));
      out.write("_modalities').multiselect({\n");
      out.write("    	        // 	columns: 2,\n");
      out.write("    	        // 	minWidth: 157,\n");
      out.write("    	        // 	selectedList: 4,\n");
      out.write("    	        // 	header: true,\n");
      out.write("    	        // 	includeSelectAllOption: true,\n");
      out.write("    	        //     noneSelectedText: \"ALL\"\n");
      out.write("    	        // });\n");
      out.write("//                var lang = getCookie('language');\n");
      out.write("//                if (lang == 'none') {\n");
      out.write("//                $.getScript('js/i18n/Bundle.js', function() {\n");
      out.write("//                    loadLabels();\n");
      out.write("//                });\n");
      out.write("//                } else {\n");
      out.write("//                var fileName = 'js/i18n/' + \"Bundle_\" + lang + \".js\";\n");
      out.write("//                        $.getScript(fileName, function() {\n");
      out.write("//                    loadLabels();\n");
      out.write("//                });\n");
      out.write("//                }\n");
      out.write("//                $(\"label[for=patId]\").text(languages['PatientId']);\n");
      out.write("//                $(\"label[for=patName]\").text(languages['PatientName']);\n");
      out.write("//                $(\"label[for=accessionNo]\").text(languages['AccessionNumber']);\n");
      out.write("//                $(\"label[for=birthDate]\").text(languages['BirthDate']);\n");
      out.write("//                $(\"label[for=studyDesc]\").text(languages['StudyDesc']);\n");
      out.write("//                $(\"label[for=referPhysician]\").text(languages['ReferPhysician']);\n");
      out.write("//                $(\".bdate\").prev().text(languages['BirthDate']);\n");
      out.write("//                $(\".fsdate\").prev().text(languages['FromStudyDate']);\n");
      out.write("//                $(\".tsdate\").prev().text(languages['ToStudyDate']);\n");
      out.write("//                $(\".searchBtn\").text(languages['Search']);\n");
      out.write("//                $(\".clearBtn\").text(languages['Reset']);\n");
      out.write("\n");
      out.write("            });  //for document.ready\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("            /* css for timepicker */\n");
      out.write("            .ui-timepicker-div .ui-widget-header { margin-bottom: 8px; }\n");
      out.write("            .ui-timepicker-div dl { text-align: left; }\n");
      out.write("            .ui-timepicker-div dl dt { height: 25px; margin-bottom: -25px; }\n");
      out.write("            .ui-timepicker-div dl dd { margin: 0 10px 10px 65px; }\n");
      out.write("            .ui-tpicker-grid-label { background: none; border: none; margin: 0; padding: 0; }\n");
      out.write("\n");
      out.write("            #newQueryParamDiv label {\n");
      out.write("                float: left;\n");
      out.write("                width: 10em;\n");
      out.write("                font-size: 13px;\n");
      out.write("                position: relative;\n");
      out.write("                top: 6px;\n");
      out.write("            }            \n");
      out.write("            \n");
      out.write("/*             .ui-state-default { */\n");
      out.write("/*             	border: 2px solid #2A2A2A !important; */\n");
      out.write("/*             } */\n");
      out.write("            \n");
      out.write("            .gentleselect-label {\n");
      out.write("            	float: left;\n");
      out.write("    			/*font-weight: bold;*/\n");
      out.write("    \n");
      out.write("    			border: 2px solid #2A2A2A !important;\n");
      out.write("    			background-image: url('css/images/expand.png');\n");
      out.write("    			display: block;    \n");
      out.write("				width: 13em;\n");
      out.write("				height: 20px;\n");
      out.write("				text-align: center;\n");
      out.write("				line-height: 2em;\n");
      out.write("				padding: 0px !important;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("           /* .gentleselect-dialog > ul {\n");
      out.write("            	font-weight: bold;\n");
      out.write("            }*/\n");
      out.write("            \n");
      out.write("            .gentleselect-dialog > ul > li.selected {\n");
      out.write("            	color: #fff;\n");
      out.write("			    background-color: #0b93d5;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .gentleselect-dialog > ul > li:hover {\n");
      out.write("            	 background-color: #0972a5;\n");
      out.write("			    color: #fff;\n");
      out.write("            }\n");
      out.write("            #findTable label{\n");
      out.write("                font-size: 14px;\n");
      out.write("            }\n");
      out.write("           \n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"newQueryParamDiv\" class=\"ui-widget-content\">\n");
      out.write("<!--             <table id=\"findTable\" class=\"ui-widget-content\" width=\"930px\" height=\"90%\" cell-spacing=\"4\" style=\"margin-left: 10px; font-size: 100%;border: none;\"> -->\n");
      out.write("<table id=\"findTable\" class=\"ui-widget-content\" width=\"100%\" height=\"90%\"  cellspacing=\"4\" style=\"margin-left: 10px; font-size: 100%;border: none;\">\n");
      out.write("                <tr>\n");
      out.write("<!--                     <td style=\"width:50px;\"> -->\n");
      out.write("						<td>\n");
      out.write("                        <label for=\"patId\">Patient ID</label>\n");
      out.write("                        <input type=\"search\" id=\"patId\" name='patId' placeholder=\"Patient ID\" />\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <label for=\"patName\">Patient Name</label>\n");
      out.write("                        <input type=\"search\" id=\"patName\" name='patName' placeholder=\"Patient Name\" />\n");
      out.write("                    </td>\n");
      out.write("                   <!-- <td>\n");
      out.write("                        <label for=\"accessionNo\">Accession Number</label>\n");
      out.write("                        <input type=\"search\" id=\"accessionNo\" />\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <label>Birth Date</label>\n");
      out.write("                        <input type=\"search\" class=\"bdate\" />\n");
      out.write("                    </td>-->\n");
      out.write("                    \n");
      out.write("                    <td>\n");
      out.write("                        <label>Study Date (From)</label>\n");
      out.write("                        <input type=\"search\" class=\"fsdate\" placeholder=\"MM/DD/YYYY\" />\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <label>Study Date (To)</label>\n");
      out.write("                        <input type=\"search\" class=\"tsdate\" placeholder=\"MM/DD/YYYY\"/>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>   \n");
      out.write("                	<td>\n");
      out.write("                        <label for=\"studyDesc\">Study Description</label>\n");
      out.write("                        <input type=\"search\" id=\"studyDesc\" name=\"studyDesc\" placeholder=\"Study/Procedure name\" />\n");
      out.write("                    </td>\n");
      out.write("                                     \n");
      out.write("                    <td>\n");
      out.write("                        <label for=\"referPhysician\">Referring Physician</label>\n");
      out.write("                        <input type=\"search\" id=\"referPhysician\"  name=\"referPhysician\" placeholder=\"Referring Physician\" />\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                    	<div style=\"float: left; width: 10em; font-size: 14px; margin-top: 6px;\"name='lblModality'> Modality </div>\n");
      out.write("                       \n");
      out.write("                        <select id=\"");
      out.print(request.getParameter("tabName"));
      out.write("_modalities\" multiple=\"multiple\" class=\"modalitiesList ");
      out.print(request.getParameter("tabName"));
      out.write("_modalities\" style=\"display: none;\">\n");
      out.write("                            \n");
      out.write("                            <option value=\"CT\">CT</option>\n");
      out.write("                            <option value=\"CR\">CR</option>\n");
      out.write("                            <option value=\"XA\">XA</option>\n");
      out.write("                            <option value=\"MR\">MR</option>\n");
      out.write("                            <option value=\"US\">US</option>\n");
      out.write("                            <option value=\"DX\">DX</option>\n");
      out.write("                            <option value=\"PX\">PX</option>\n");
      out.write("                            <option value=\"SC\">SC</option>\n");
      out.write("                            <option value=\"NM\">NM</option>\n");
      out.write("                            <option value=\"RF\">RF</option>\n");
      out.write("                            <option value=\"OT\">OT</option>\n");
      out.write("                            <option value=\"ECG\">ECG</option>  \n");
      out.write("                                                                             \n");
      out.write("                        </select>    \n");
      out.write("\n");
      out.write("                    </td>                     \n");
      out.write("                    <td colspan=\"2\">   \n");
      out.write("                    	<button id=\"okBtn\" onclick=\"searchClick(this)\" style=\"float: left;width:7em;height:27px; font-size: 14px; margin-right: 10px;\" class=\"searchBtn\">Search</button>                                            	\n");
      out.write("    	                	<button id=\"resetBtn\" onclick=\"resetClick(this, ");
      out.print(request.getParameter("tabName"));
      out.write("_modalities);\" style=\"float: left;width:7em; height:27px; font-size: 14px;\" class=\"clearBtn\"> Reset</button>           	                    	\n");
      out.write("	                	</td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
