package servlet;

import java.io.IOException;

import javax.servlet.ServletOutputStream;

public class PrintHTML {
	
	public void printHeader(ServletOutputStream out) throws IOException{
		out.println("<html>"
				+ "<head>"
				+ "<meta charset='utf-8'><meta name='viewport' content='width=device-width, initial-scale=1'>"
				+ "<script type='text/javascript' src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js'></script>"
				+ "<script type='text/javascript' src='http://netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js'></script>"
				+ "<link href='http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css' rel='stylesheet' type='text/css'>"
				+ "<link href='http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css' rel='stylesheet' type='text/css'>"
				+ "</head>"
				+ "<body>"
				+ "<div class='navbar navbar-default navbar-static-top'>"
				+ "<div class='container'>"
				+ "<div class='navbar-header'>"
				+ "<button type='button' class='navbar-toggle' data-toggle='collapse' data-target='#navbar-ex-collapse'>"
				+ "<span class='sr-only'>Toggle navigation</span>"
				+ "<span class='icon-bar'></span>"
				+ "<span class='icon-bar'></span>"
				+ "<span class='icon-bar'></span>"
				+ "</button>"
				+ "<a class='navbar-brand'><span>OPower</span></a>"
				+ "</div>"
				+ "<div class='collapse navbar-collapse' id='navbar-ex-collapse'>"
				+ "<ul class='nav navbar-nav navbar-right'>"
				+ "<li class='active'>"
				+ "<a href='#'>Accueil</a>"
				+ "</li>"
				+ "<li class='dropdown'>"
				+ "<a href='#' class='dropdown-toggle' data-toggle='dropdown' role='button' aria-expanded='false'>Personnes<span class='caret'></span></a>"
				+ "<ul class='dropdown-menu' role='menu'>"
				+ "<li>"
				+ "<a href='/persons'>Toutes les personnes</a>"
				+ "</li>"
				+ "<li>"
				+ "<a href='#'>Créer son compte</a>"
				+ "</li>"
				+ "</ul>"
				+ "</li>"
				+ "<li class='dropdown'>"
				+ "<a href='#' class='dropdown-toggle' data-toggle='dropdown' role='button' aria-expanded='false'>Appareils<span class='caret'></span></a>"
				+ "<ul class='dropdown-menu' role='menu'>"
				+ "<li>"
				+ "<a href='/devices'>Tous les appareils</a>"
				+ "</li>"
				+ "</ul>"
				+ "</li>"
				+ "<li class='dropdown'>"
				+ "<a href='#' class='dropdown-toggle' data-toggle='dropdown' role='button'"
				+ "aria-expanded='false'>Maisons<span class='caret'></span></a>"
				+ "<ul class='dropdown-menu' role='menu'>"
				+ "<li>"
				+ "<a href='/homes'>Toutes les maisons</a>"
				+ "</li>"
				+ "</ul>"
				+ "</li>"
				+ "</ul>"
				+ "</div>"
				+ "</div>"
				+ "</div>"
				+"<div class='section'>"
		        +"<div class='container'>"
		        +"<div class='row'>"
		        +"<div class='col-md-12'>");
	}
	
	public void printFooter(ServletOutputStream out) throws IOException{
		out.println("</div></div></div></div><footer class='section section-success'>"
				+ "<div class='container'>"
				+ "<div class='row'>"
				+ "<div class='col-sm-6'>"
				+ "<h1>Created by</h1>"
				+ "<p>Julien Moulin</p>"
				+ "<p>M1 MIAGE - TP SIR</p>"
				+ "</div>"
				+ "<div class='col-sm-6'>"
				+ "<p class='text-info text-right'>"
				+ "<br>"
				+ "<br>"
				+ "</p>"
				+ "<div class='row'>"
				+ "<div class='col-md-12 hidden-lg hidden-md hidden-sm text-left'>"
				+ "<a href='#'><i class='fa fa-3x fa-fw fa-instagram text-inverse'></i></a>"
				+ "<a href='#'><i class='fa fa-3x fa-fw fa-twitter text-inverse'></i></a>"
				+ "<a href='#'><i class='fa fa-3x fa-fw fa-facebook text-inverse'></i></a>"
				+ "<a href='#'><i class='fa fa-3x fa-fw fa-github text-inverse'></i></a>"
				+ "</div>"
				+ "</div>"
				+ "<div class='row'>"
				+ "<div class='col-md-12 hidden-xs text-right'>"
				+ "<a href='#'><i class='fa fa-3x fa-fw fa-instagram text-inverse'></i></a>"
				+ "<a href='#'><i class='fa fa-3x fa-fw fa-twitter text-inverse'></i></a>"
				+ "<a href='#'><i class='fa fa-3x fa-fw fa-facebook text-inverse'></i></a>"
				+ "<a href='#'><i class='fa fa-3x fa-fw fa-github text-inverse'></i></a>"
				+ "</div>"
				+ "</div>"
				+ "</div>"
				+ "</div>"
				+ "</div>"
				+ "</footer>"
				+ "</body>");
	}

}
