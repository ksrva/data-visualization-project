//Kamakshi
/*
 * Panel that holds contents for recommendation panel survey JButtons as well as their action Listeners 
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jfree.chart.ChartPanel;

import controller.GeoFileImportController;
import model.GeoService;
import model.Region;

public class GeoRecommendationPanel extends JPanel {
	
	private JTextArea answerArea; 
	
	private JLabel surveyLabel; 
	
	private JLabel taxTerm; 
	private JButton taxAny; 
	private JButton taxSubstance; 
	private JButton taxLoss; 
	private JButton taxLGBT; 
	private ArrayList<JButton> taxList;
	
	private JLabel pricing; 
	private JButton priceAny; 
	private JButton priceFree; 
	private JButton priceNom; 
	private JButton priceOHIP; 
	private ArrayList<JButton> priceList;
	
	private JLabel eligibility; 
	private JButton eligAny; 
	private JButton eligYouth; 
	private JButton eligAbo; 
	private JButton eligWomen; 
	private ArrayList<JButton> eligList;
	
	private JButton redo; 
	private JButton submit;
	
	private ArrayList<String> answerList; 
	private ArrayList<GeoService> recommendedServices; 
	
	public GeoRecommendationPanel () {
		
		
		setLayout(null);
		setVisible(true);
		setBackground(GeoPanel.getColor1());
		
		answerList = new ArrayList<String>(); 
		taxList = new ArrayList<JButton>(); 
		priceList = new ArrayList<JButton>(); 
		eligList = new ArrayList<JButton>(); 
		
		answerArea = new JTextArea(" "); 
		answerArea.setBackground(GeoPanel.getColor1());
		answerArea.setForeground(GeoPanel.getColor4());
		answerArea.setLayout(null);
		answerArea.setVisible(true);
		add(answerArea); 
		GeoPanel.getScrollPaneReco().setViewportView(answerArea); 
		
		
		
		recommendedServices = new ArrayList<GeoService>(); 
		
		disableButtons(taxList, true); 
		
		surveyLabel = new JLabel("Select from the following settings to get a list of recommended Mental Health Services."); 
		surveyLabel.setLayout(null);
		surveyLabel.setBounds(10, 20, 200, 20);
		surveyLabel.setForeground(GeoPanel.getColor1());
		add(surveyLabel); 
		
		taxTerm = new JLabel("Select Service Focus"); 
		taxTerm.setLayout(null);
		taxTerm.setBounds(10, 20+45, 200, 20);
		taxTerm.setForeground(GeoPanel.getColor1());
		add(taxTerm); 
		

		taxAny = new JButton("Any"); 
		taxList.add(taxAny);
		taxSubstance = new JButton("Substance Abuse");
		taxList.add(taxSubstance);
		taxLoss = new JButton("Grief and Loss");
		taxList.add(taxLoss);
		taxLGBT = new JButton("LGBTQ2S+ Community"); 
		taxList.add(taxLGBT);
		
		
		
		taxAny.setBounds(10,20+45+20,160,40);
		taxAny.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				disableButtons(taxList, false); 
				
				
				answerList.add("Service Focus Selected: Any"); 
				
				String display = ""; 
				for(String current : answerList) {
					display = display + "\n" + current; 
				}
				
				answerArea.setText(display);
				GeoPanel.getScrollPaneReco().setViewportView(answerArea); 
				GeoPanel.getGeoRecoPanel().add(GeoPanel.getScrollPaneReco()); 
				
				disableButtons(priceList, true);
				
			}
		});
		add(taxAny);
		
		taxSubstance.setBounds(10+160,20+45+20,160,40);
		taxSubstance.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				disableButtons(taxList, false); 
				
				
				answerList.add("Service Focus Selected: Substance"); 
				
				String display = ""; 
				for(String current : answerList) {
					display = display + "\n" + current; 
				}
				
				answerArea.setText(display);
				GeoPanel.getScrollPaneReco().setViewportView(answerArea); 
				GeoPanel.getGeoRecoPanel().add(GeoPanel.getScrollPaneReco()); 
				
				disableButtons(priceList, true);
				
			}
		});
		add(taxSubstance);
		
		taxLoss.setBounds(10,20+45+20+40,160,40);
		taxLoss.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				disableButtons(taxList, false); 
				
				
				answerList.add("Service Focus Selected: Grief and Loss"); 
				
				String display = ""; 
				for(String current : answerList) {
					display = display + "\n" + current; 
				}
				
				answerArea.setText(display);
				GeoPanel.getScrollPaneReco().setViewportView(answerArea); 
				GeoPanel.getGeoRecoPanel().add(GeoPanel.getScrollPaneReco()); 
				
				disableButtons(priceList, true);
				
			}
		});
		add(taxLoss);
		
		taxLGBT.setBounds(10+160,20+45+20+40,160,40);
		taxLGBT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				disableButtons(taxList, false); 
				
				
				answerList.add("Service Focus Selected: LGBT"); 
				
				String display = ""; 
				for(String current : answerList) {
					display = display + "\n" + current; 
				}
				
				answerArea.setText(display);
				GeoPanel.getScrollPaneReco().setViewportView(answerArea); 
				GeoPanel.getGeoRecoPanel().add(GeoPanel.getScrollPaneReco()); 
				
				disableButtons(priceList, true); 
				
			}
		});
		add(taxLGBT);
		
		
		
		
		pricing = new JLabel("Select Preffered Fee Structure"); 
		pricing.setLayout(null);
		pricing.setBounds(13, 20+45+20+40+40, 200, 20);
		pricing.setForeground(GeoPanel.getColor1());
		add(pricing); 
		
		priceAny = new JButton("Any"); 
		priceList.add(priceAny);
		priceFree = new JButton("Free");
		priceList.add(priceFree);
		priceNom = new JButton("Nominal Fee");
		priceList.add(priceNom);
		priceOHIP = new JButton("OHIP Covered"); 
		priceList.add(priceOHIP);

		priceAny.setBounds(10,190,160,40);
		priceAny.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				disableButtons(priceList, false); 
				
				
				answerList.add("Service Fee Structure Selected: Any"); 
				
				String display = ""; 
				for(String current : answerList) {
					display = display + "\n" + current; 
				}
				
				answerArea.setText(display);
				GeoPanel.getScrollPaneReco().setViewportView(answerArea); 
				GeoPanel.getGeoRecoPanel().add(GeoPanel.getScrollPaneReco()); 
				
				disableButtons(eligList, true);
				
			}
		});
		add(priceAny);
		
		priceFree.setBounds(10+160,190,160,40);
		priceFree.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				disableButtons(priceList, false); 
				
				
				answerList.add("Service Fee Structure Selected: Free"); 
				
				String display = ""; 
				for(String current : answerList) {
					display = display + "\n" + current; 
				}
				
				answerArea.setText(display);
				GeoPanel.getScrollPaneReco().setViewportView(answerArea); 
				GeoPanel.getGeoRecoPanel().add(GeoPanel.getScrollPaneReco()); 
				
				disableButtons(eligList, true);
				
			}
		});
		add(priceFree);
		
		priceNom.setBounds(10,190+40,160,40);
		priceNom.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				disableButtons(priceList, false); 
				
				
				answerList.add("Service Fee Structure Selected: Nominal Fee"); 
				
				String display = ""; 
				for(String current : answerList) {
					display = display + "\n" + current; 
				}
				
				answerArea.setText(display);
				GeoPanel.getScrollPaneReco().setViewportView(answerArea); 
				GeoPanel.getGeoRecoPanel().add(GeoPanel.getScrollPaneReco()); 
				
				disableButtons(eligList, true);
				
			}
		});
		add(priceNom);
		
		priceOHIP.setBounds(10+160,190+40,160,40);
		priceOHIP.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				disableButtons(priceList, false); 
				
				
				answerList.add("Service Fee Structure Selected: OHIP"); 
			
				String display = ""; 
				for(String current : answerList) {
					display = display + "\n" + current; 
				}
				
				answerArea.setText(display);
				GeoPanel.getScrollPaneReco().setViewportView(answerArea); 
				GeoPanel.getGeoRecoPanel().add(GeoPanel.getScrollPaneReco()); 
				
				disableButtons(eligList, true);
				
			}
		});
		add(priceOHIP);


		
		eligibility = new JLabel("Select Eligibility"); 
		eligibility.setLayout(null);
		eligibility.setBounds(13, 190+40+50, 200, 20);
		eligibility.setForeground(GeoPanel.getColor1());
		add(eligibility); 
		
		eligAny = new JButton("Any"); 
		eligList.add(eligAny);
		eligYouth = new JButton("Youth");
		eligList.add(eligYouth);
		eligAbo = new JButton("Aboriginal");
		eligList.add(eligAbo);
		eligWomen = new JButton("Women"); 
		eligList.add(eligWomen);

		eligAny.setBounds(10,300,160,40);
		eligAny.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				disableButtons(priceList, false); 
				
				
				answerList.add("Service Eligibility Selected: Any"); 
				
				String display = ""; 
				for(String current : answerList) {
					display = display + "\n" + current; 
				}
				
				answerArea.setText(display);
				GeoPanel.getScrollPaneReco().setViewportView(answerArea); 
				GeoPanel.getGeoRecoPanel().add(GeoPanel.getScrollPaneReco()); 
				
				submit.setEnabled(true);
				
			}
		});
		add(eligAny);
		
		eligYouth.setBounds(10+160,300,160,40);
		eligYouth.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				disableButtons(priceList, false); 
				
				
				answerList.add("Service Eligibility Selected: Youth"); 
				
				String display = ""; 
				for(String current : answerList) {
					display = display + "\n" + current; 
				}
				
				answerArea.setText(display);
				GeoPanel.getScrollPaneReco().setViewportView(answerArea); 
				GeoPanel.getGeoRecoPanel().add(GeoPanel.getScrollPaneReco()); 
				
				submit.setEnabled(true);
				
			}
		});
		add(eligYouth);
		
		
		
		eligAbo.setBounds(10,300+40,160,40);
		eligAbo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				disableButtons(priceList, false); 
				
				
				answerList.add("Service Eligibility Selected: Aboriginal"); 
				
				String display = ""; 
				for(String current : answerList) {
					display = display + "\n" + current; 
				}
				
				answerArea.setText(display);
				GeoPanel.getScrollPaneReco().setViewportView(answerArea); 
				GeoPanel.getGeoRecoPanel().add(GeoPanel.getScrollPaneReco()); 
				
				submit.setEnabled(true);
				
			}
		});
		add(eligAbo);
		
		eligWomen.setBounds(10+160,300+40,160,40);
		eligWomen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				disableButtons(priceList, false); 
				
				
				answerList.add("Service Eligibility Selected: Women"); 
				
				String display = ""; 
				for(String current : answerList) {
					display = display + "\n" + current; 
				}
				
				answerArea.setText(display);
				GeoPanel.getScrollPaneReco().setViewportView(answerArea); 
				GeoPanel.getGeoRecoPanel().add(GeoPanel.getScrollPaneReco()); 
	
				submit.setEnabled(true);
				
			}
		});
		add(eligWomen);
		
		redo = new JButton("Redo"); 
		redo.setBounds(10,300+40+80,90,40);
		redo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				answerList.clear();
				recommendedServices.clear(); 
				
				String display = ""; 
				for(String current : answerList) {
					display = display + "\n" + current; 
				}
				answerArea.setText(display);
				GeoPanel.getScrollPaneReco().setViewportView(answerArea); 
				GeoPanel.getGeoRecoPanel().add(GeoPanel.getScrollPaneReco());  
				
				disableButtons(taxList, true);
				disableButtons(priceList, false);
				disableButtons(eligList, false);
				submit.setEnabled(false);
				
				
			}
		});
		add(redo);
		
		
		
		submit = new JButton("Submit"); 
		submit.setBounds(10+160,300+40+80,90,40);
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				disableButtons(taxList, false);
				disableButtons(priceList, false);
				disableButtons(eligList, false);
				
				for(GeoService cur : GeoFileImportController.geoServices) {
					recommendedServices.add(cur);
				}
				
				
				if(!answerList.get(0).substring(24).equals("Any")) {
					System.out.println(answerList.get(0).substring(24));
					
					ArrayList<GeoService> recoService1 = new ArrayList<GeoService>();
					for(GeoService cur : recommendedServices) {
						recoService1.add(cur); 
					}
					
					for(GeoService cur : recoService1) {
						if(!cur.getTaxonomyTerm().contains(answerList.get(0).substring(24))) {
							recommendedServices.remove(cur);
						}
						
					}
					System.out.println(recommendedServices.size()); 
				}
				
				//Fee Structure
				if(!answerList.get(1).substring(32).equals("Any")) {
					System.out.println(answerList.get(1).substring(32,35));

					ArrayList<GeoService> recoService2 = new ArrayList<GeoService>();
					for(GeoService cur : recommendedServices) {
						recoService2.add(cur); 
					}
					
					for(GeoService cur : recoService2) {
						if(!cur.getFeeStructure().contains(answerList.get(1).substring(32))) {
							recommendedServices.remove(cur);
						}
						
					}
					System.out.println(recommendedServices.size()); 
				}
				
				//Elibility 
				if(!answerList.get(2).substring(30).equals("Any")) {
					System.out.println(answerList.get(2).substring(30));
					

					ArrayList<GeoService> recoService3 = new ArrayList<GeoService>();
					for(GeoService cur : recommendedServices) {
						recoService3.add(cur); 
					}
					
					for(GeoService cur : recoService3) {
						if(!cur.getEligibility().contains(answerList.get(2).substring(30))) {
							recommendedServices.remove(cur);
						}
					}
					System.out.println(recommendedServices.size()); 
				}
				
				String display = " ";
				if(recommendedServices.size() == 0) {
					display = "No services with current settings available"; 
				}else {
					 
					for(GeoService current : recommendedServices) {
						display = display + "\n\n" + current.print(); 
					}
				}
	
				answerArea.setText(display);
				GeoPanel.getScrollPaneReco().setViewportView(answerArea); 
				GeoPanel.getGeoRecoPanel().add(GeoPanel.getScrollPaneReco());  
				
				
			}
		});
		add(submit);
		
		
		disableButtons(priceList, false);
		disableButtons(eligList, false);
		
		submit.setEnabled(false);
		
		
		
		
	}
	
	public static void disableButtons(ArrayList<JButton> list, boolean status) {
		for(JButton cur : list) {
			cur.setEnabled(status);
		}
	}
	
}
