package indra.bp;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import org.apache.commons.io.FileUtils;
import org.vaadin.easyuploads.UploadField;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.HasValue.ValueChangeEvent;
import com.vaadin.data.HasValue.ValueChangeListener;
import com.vaadin.event.ShortcutAction;
import com.vaadin.event.ShortcutListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.Upload;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import server.Engine;
<<<<<<< HEAD

@Theme("tema")
public class Vedere extends UI {
    boolean este;File tempfile;	
    public Clustering clust;
    public ArrayList<Stkview> selectate=new ArrayList<Stkview>();
	boolean admin=false;
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        setContent(layout);
        layout.setStyleName("toata");
        if (admin==false) {layout.addComponent(tabsusr());}else{layout.addComponent(tabs());}
        layout.setWidth("100%");layout.setHeight("100%");
        layout.addShortcutListener(new ShortcutListener(null, ShortcutAction.KeyCode.F7,null) {	
			@Override
			public void handleAction(Object sender, Object target) {
				Window win=new Window();
				VerticalLayout tot=new VerticalLayout();
				tot.setWidth("450px");tot.setHeight("70px");
				win.setContent(tot);
				PasswordField pass=new PasswordField();
				 UploadField uploadField = new UploadField();uploadField.setWidth("500px");uploadField.setHeight("300px");
			        Button b=new Button("select eradata.xlxs");
			        b.addClickListener(new ClickListener() {						
					@Override
						public void buttonClick(ClickEvent event) {
							byte[]value =uploadField.getValue();
							try {FileUtils.writeByteArrayToFile(new File("sascris.txt"), value);} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					});
				Button go=new Button("Go");
				go.addClickListener(new ClickListener() {
					@Override
					public void buttonClick(ClickEvent event) {
						String pwd=pass.getValue();
						if(pwd.equals("password")) {
							admin=true;
							//tot.addComponent(uploadField);tot.setHeight("300px");
							layout.removeAllComponents();layout.addComponent(tabs());
						}else {Notification.show("That's not the right password.");}
					}
				});
				HorizontalLayout rand=new HorizontalLayout();
				rand.addComponents(pass,go);
				tot.addComponent(rand);tot.setComponentAlignment(rand, Alignment.MIDDLE_CENTER);
				getCurrent().getUI().addWindow(win);win.center();
			}
		});	
    }
	VerticalLayout pub() {
		VerticalLayout me=new VerticalLayout();
		VerticalLayout list=new VerticalLayout();
    	VerticalLayout charts=new VerticalLayout();
    	VerticalLayout stakeholders=new VerticalLayout();
    	VerticalLayout scroll=new VerticalLayout();
    	VerticalLayout proxies=new VerticalLayout();
    	VerticalLayout electorate=new VerticalLayout();
    	Topline top=new Topline("Account", "Share of Votes", "Number of Votes", "EOS/Vote", "Location");
    	list.addComponent(top);
    	list.setStyleName("toata");
    	list.addComponent(scroll);
    	list.setExpandRatio(top, 1);
    	list.setExpandRatio(scroll, 17);list.setHeight("100%");
    	scroll.setStyleName("scroll");
    	me.addComponent(list);me.setStyleName("terselect");me.setHeight("100");
    	for (int i=0;i<Engine.producers.size();i++) {
    		 scroll.addComponent(new BPview(Engine.producers.get(i),i+1));
    	}
    	return me;
		}
    TabSheet tabs () {
	    	TabSheet me=new TabSheet();me.setStyleName("terselect");me.setSizeFull();
	    	VerticalLayout list=new VerticalLayout();
	    	VerticalLayout charts=new VerticalLayout();
	    	VerticalLayout stakeholders=new VerticalLayout();
	    	VerticalLayout scroll=new VerticalLayout();
	    	VerticalLayout proxies=new VerticalLayout();
	    	VerticalLayout electorate=new VerticalLayout();
	    	Topline top=new Topline("Account", "Share of Votes", "Number of Votes", "EOS/Vote", "Location");
	    	list.addComponent(top);
	    	list.setStyleName("toata");
	    	list.addComponent(scroll);
	    	list.setExpandRatio(top, 1);
	    	list.setExpandRatio(scroll, 17);
	    	scroll.setStyleName("toata");
	    	me.addTab(list,"BPs");
	    	for (int i=0;i<Engine.producers.size();i++) {
	    		 scroll.addComponent(new BPview(Engine.producers.get(i),i+1));
	    	}
	    	me.addTab(stakeholders,"Electorate");
	    	stakeholders.setHeight("100%");stakeholders.setWidth("100%");
	    	HorizontalLayout hori=new HorizontalLayout();
	    	hori.setHeight("100%");hori.setWidth("100%");hori.setStyleName("toata");
	    	VerticalLayout stakelist=new VerticalLayout();
	    	stakelist.setStyleName("hidden");
	    	VerticalLayout bara=new VerticalLayout();
	    	VerticalLayout dreapta=new VerticalLayout();
	    	stakeholders.addComponent(hori);stakeholders.setStyleName("toata");
	    	hori.addComponents(stakelist,dreapta);
	    	hori.setExpandRatio(stakelist, 2);hori.setExpandRatio(dreapta, 5);
	    	CheckBox checktoate=new CheckBox();checktoate.setValue(este);
	    	BaraStk barastk=new BaraStk(checktoate);
	    	VerticalLayout chiarlista=new VerticalLayout();
	    	chiarlista.setStyleName("toata");
	    	Panel panelstake=new Panel();panelstake.setHeight("100%");
	    	panelstake.setContent(chiarlista);chiarlista.setSizeUndefined();
	    	stakelist.setHeight("100%");stakelist.setStyleName("toata");
	    	stakelist.setWidth("100%");panelstake.setWidth("100%");
	    	stakelist.addComponents(barastk,panelstake);chiarlista.setStyleName("toata");
	    	stakelist.setExpandRatio(barastk, 1);
	    	stakelist.setExpandRatio(panelstake, 13);
	    	chiarlista.setWidth("100%");
	    	Dreapta pedreapta=new Dreapta();
	    	SmallVotes sv=new SmallVotes("Small Votes", new ArrayList<String>(), "", 43166090);
	    	Stkviewm mici=new Stkviewm(sv, pedreapta, null, null, false, 0.0);
	    	chiarlista.addComponent(mici);
	    	for(int i=0;i<Engine.stakeholders.size();i++) {
	    		Engine.stakeholders.get(i).vedere=new Stkview(Engine.stakeholders.get(i),pedreapta,null,null,false,0.0);
	    		chiarlista.addComponent(Engine.stakeholders.get(i).vedere);
    	}
    	checktoate.addValueChangeListener(new ValueChangeListener<Boolean>() {
			public void valueChange(ValueChangeEvent<Boolean> event) {
				System.out.println("booleanu e "+este);
				if (este==true) {
					for (int i=0;i<Engine.stakeholders.size();i++)
					{Engine.stakeholders.get(i).vedere.chec.setValue(false);}
					este=false;
				}
				else {
					for (int i=0;i<Engine.stakeholders.size();i++)
					{Engine.stakeholders.get(i).vedere.chec.setValue(true);}
					este=true;}
			}
		});
    	dreapta.addComponent(pedreapta);
    	me.addTab(charts, "Groups");charts.setStyleName("toata");
    	clust=new Clustering();	clust.setHeight("100%");
    	charts.addComponent(clust);
    	return me;
    }
    VerticalLayout tabsusr () {
    	VerticalLayout me=new VerticalLayout();me.setStyleName("toata");
    	me.setHeight("100%");
    	VerticalLayout list=new VerticalLayout();
    	VerticalLayout charts=new VerticalLayout();
    	VerticalLayout stakeholders=new VerticalLayout();
    	VerticalLayout scroll=new VerticalLayout();
    	VerticalLayout proxies=new VerticalLayout();		
=======
@Theme("tema")
public class Vedere extends UI {
    boolean este;File tempfile;	
    public Clustering clust;
    public ArrayList<Stkview> selectate=new ArrayList<Stkview>();
	boolean admin=false;
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        setContent(layout);
        layout.setStyleName("toata");
        if (admin==false) {layout.addComponent(tabsusr());}else{layout.addComponent(tabs());}
        layout.setWidth("100%");layout.setHeight("100%");
        layout.addShortcutListener(new ShortcutListener(null, ShortcutAction.KeyCode.F7,null) {	
			@Override
			public void handleAction(Object sender, Object target) {
				Window win=new Window();
				VerticalLayout tot=new VerticalLayout();
				tot.setWidth("450px");tot.setHeight("70px");
				win.setContent(tot);
				PasswordField pass=new PasswordField();
				 UploadField uploadField = new UploadField();uploadField.setWidth("500px");uploadField.setHeight("300px");
			        Button b=new Button("select eradata.xlxs");
			        b.addClickListener(new ClickListener() {						
						@Override
						public void buttonClick(ClickEvent event) {
							byte[]value =uploadField.getValue();
							try {
								FileUtils.writeByteArrayToFile(new File("sascris.txt"), value);
								System.out.println("scrie ceva aici"+uploadField.getValue());
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					});
				Button go=new Button("Go");
				go.addClickListener(new ClickListener() {
					@Override
					public void buttonClick(ClickEvent event) {
						String pwd=pass.getValue();
						if(pwd.equals("password")) {
							admin=true;
							tot.addComponent(uploadField);tot.setHeight("300px");
							layout.removeAllComponents();layout.addComponent(tabs());
						}else {Notification.show("That's not the right password.");}
					}
				});
				HorizontalLayout rand=new HorizontalLayout();
				rand.addComponents(pass,go);
				tot.addComponent(rand);tot.setComponentAlignment(rand, Alignment.MIDDLE_CENTER);
				getCurrent().getUI().addWindow(win);win.center();
			}
		});	
    }
	VerticalLayout pub() {
		VerticalLayout me=new VerticalLayout();
		VerticalLayout list=new VerticalLayout();
    	VerticalLayout charts=new VerticalLayout();
    	VerticalLayout stakeholders=new VerticalLayout();
    	VerticalLayout scroll=new VerticalLayout();
    	VerticalLayout proxies=new VerticalLayout();
    	VerticalLayout electorate=new VerticalLayout();
    	Topline top=new Topline("Account", "Share of Votes", "Number of Votes", "EOS/Vote", "Location");
    	list.addComponent(top);
    	list.setStyleName("toata");
    	list.addComponent(scroll);
    	list.setExpandRatio(top, 1);
    	list.setExpandRatio(scroll, 17);list.setHeight("100%");
    	scroll.setStyleName("scroll");
    	me.addComponent(list);me.setStyleName("terselect");me.setHeight("100");
    	for (int i=0;i<Engine.producers.size();i++) {
    		 scroll.addComponent(new BPview(Engine.producers.get(i),i+1));
    	}
    	return me;
		}
    TabSheet tabs () {
	    	TabSheet me=new TabSheet();me.setStyleName("terselect");me.setSizeFull();
	    	VerticalLayout list=new VerticalLayout();
	    	VerticalLayout charts=new VerticalLayout();
	    	VerticalLayout stakeholders=new VerticalLayout();
	    	VerticalLayout scroll=new VerticalLayout();
	    	VerticalLayout proxies=new VerticalLayout();
	    	VerticalLayout electorate=new VerticalLayout();
	    	Topline top=new Topline("Account", "Share of Votes", "Number of Votes", "EOS/Vote", "Location");
	    	list.addComponent(top);
	    	list.setStyleName("toata");
	    	list.addComponent(scroll);
	    	list.setExpandRatio(top, 1);
	    	list.setExpandRatio(scroll, 17);
	    	scroll.setStyleName("toata");
	    	me.addTab(list,"BPs");
	    	for (int i=0;i<Engine.producers.size();i++) {
	    		 scroll.addComponent(new BPview(Engine.producers.get(i),i+1));
	    	}
	    	me.addTab(stakeholders,"Electorate");
	    	stakeholders.setHeight("100%");stakeholders.setWidth("100%");
	    	HorizontalLayout hori=new HorizontalLayout();
	    	hori.setHeight("100%");hori.setWidth("100%");hori.setStyleName("toata");
	    	VerticalLayout stakelist=new VerticalLayout();
	    	stakelist.setStyleName("hidden");
	    	VerticalLayout bara=new VerticalLayout();
	    	VerticalLayout dreapta=new VerticalLayout();
	    	stakeholders.addComponent(hori);stakeholders.setStyleName("toata");
	    	hori.addComponents(stakelist,dreapta);
	    	hori.setExpandRatio(stakelist, 2);hori.setExpandRatio(dreapta, 5);
	    	CheckBox checktoate=new CheckBox();checktoate.setValue(este);
	    	BaraStk barastk=new BaraStk(checktoate);
	    	VerticalLayout chiarlista=new VerticalLayout();
	    	chiarlista.setStyleName("toata");
	    	Panel panelstake=new Panel();panelstake.setHeight("100%");
	    	panelstake.setContent(chiarlista);chiarlista.setSizeUndefined();
	    	stakelist.setHeight("100%");stakelist.setStyleName("toata");
	    	stakelist.setWidth("100%");panelstake.setWidth("100%");
	    	stakelist.addComponents(barastk,panelstake);chiarlista.setStyleName("toata");
	    	stakelist.setExpandRatio(barastk, 1);
	    	stakelist.setExpandRatio(panelstake, 13);
	    	chiarlista.setWidth("100%");
	    	Dreapta pedreapta=new Dreapta();
	    	SmallVotes sv=new SmallVotes("Small Votes", new ArrayList<String>(), "", 43166090);
	    	Stkviewm mici=new Stkviewm(sv, pedreapta, null, null, false, 0.0);
	    	chiarlista.addComponent(mici);
	    	for(int i=0;i<Engine.stakeholders.size();i++) {
	    		Engine.stakeholders.get(i).vedere=new Stkview(Engine.stakeholders.get(i),pedreapta,null,null,false,0.0);
	    		chiarlista.addComponent(Engine.stakeholders.get(i).vedere);
    	}
    	checktoate.addValueChangeListener(new ValueChangeListener<Boolean>() {
			public void valueChange(ValueChangeEvent<Boolean> event) {
				System.out.println("booleanu e "+este);
				if (este==true) {
					for (int i=0;i<Engine.stakeholders.size();i++)
					{Engine.stakeholders.get(i).vedere.chec.setValue(false);}
					este=false;
				}
				else {
					for (int i=0;i<Engine.stakeholders.size();i++)
					{Engine.stakeholders.get(i).vedere.chec.setValue(true);}
					este=true;}
			}
		});
    	dreapta.addComponent(pedreapta);
    	me.addTab(charts, "Groups");charts.setStyleName("toata");
    	clust=new Clustering();	clust.setHeight("100%");
    	charts.addComponent(clust);
    	return me;
    }
    VerticalLayout tabsusr () {
    	VerticalLayout me=new VerticalLayout();me.setStyleName("toata");
    	me.setHeight("100%");
    	VerticalLayout list=new VerticalLayout();
    	VerticalLayout charts=new VerticalLayout();
    	VerticalLayout stakeholders=new VerticalLayout();
    	VerticalLayout scroll=new VerticalLayout();
    	VerticalLayout proxies=new VerticalLayout();
>>>>>>> branch 'master' of https://github.com/gsampathkumar/EOS-Electorate-Research-Model.git
    	VerticalLayout electorate=new VerticalLayout();
    	Topline top=new Topline("Account", "Share of Votes", "Number of Votes", "EOS/Vote", "Location");
    	top.setStyleName("terselect");top.setWidth("97%");
    	list.addComponent(top);list.setComponentAlignment(top, Alignment.TOP_LEFT	);
    	list.setStyleName("toata");list.setHeight("100%");
    	Panel pan=new Panel();pan.setStyleName("terselect");
    	pan.setHeight("100%");
    	list.addComponent(pan);
    	list.setExpandRatio(top, 1);
    	list.setExpandRatio(pan, 17);
    	scroll.setStyleName("toata");
    	pan.setContent(scroll);
    	me.addComponent(list);
    	for (int i=0;i<Engine.producers.size();i++) {
    		 scroll.addComponent(new BPview(Engine.producers.get(i),i+1));
    	}
    	return me;
    }
    @WebServlet(urlPatterns = "/*", name = "VedereServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = Vedere.class, productionMode = false)
    public static class VedereServlet extends VaadinServlet {
    }
}
