//Matthew Sams 10/7/21 
/**This has been a tough process but this is the build for this app that I will be turning in. I am sure there was some better ways to code some 
 * of this. I plan on continuing to implement on this until it gets to a point where I feel comfortable releasing it to the public. I also need to 
 * convert this to more of a mobile platform basis*/
package application;

import java.io.*;
import java.nio.file.Files;
import java.util.List;
import javafx.application.Application;
import javafx.event.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.stage.FileChooser;
import javafx.scene.layout.BorderPane;


public class MainMenu extends Application {
	
	//Create the buttons and labels for the Main Menu Scene
	private Label lblTitle = new Label("DM Playtest Toolkit");
	private Button btCreatorScene = new Button("Creator");
	private Button btDiceScene = new Button("Roll Dice");
	private Button btTestScene = new Button("Test Creation");
	
	//Create textfields, choicesboxes, and labels for Creator Scene
	private Label lblTitleCreator = new Label("DM Playtest Toolkit: Creator");
	private TextField tfName = new TextField();
	private ChoiceBox<String> cbStrength = new ChoiceBox<String>();
	private ChoiceBox<String> cbDex = new ChoiceBox<String>();
	private ChoiceBox<String> cbCon = new ChoiceBox<String>();
	private ChoiceBox<String> cbInt = new ChoiceBox<String>();
	private ChoiceBox<String> cbWis = new ChoiceBox<String>();
	private ChoiceBox<String> cbChar = new ChoiceBox<String>();
	private TextField tfHP = new TextField();
	private TextField tfAC = new TextField();
	private TextField tfSpd = new TextField();
	private TextField tfSize = new TextField();
	private TextField tfLvl = new TextField();
	private ChoiceBox<String> cbProf = new ChoiceBox<String>();
	private RadioButton rbD4 = new RadioButton("D4");
	private RadioButton rbD6 = new RadioButton("D6");
	private RadioButton rbD8 = new RadioButton("D8");
	private RadioButton rbD10 = new RadioButton("D10");
	private RadioButton rbD12 = new RadioButton("D12");
	private RadioButton rbStrength = new RadioButton("Strength");
	private RadioButton rbDex = new RadioButton("Dexterity");
	private Button btTestToHit = new Button("Test Roll To Hit");
	private TextField tfTestToHit = new TextField();
	private Button btTestAttack = new Button("Test Attack Roll");
	private TextField tfTestAttack = new TextField();
	private Button btSave =  new Button("Save Creation");
	private Button btMainFromCreator = new Button("Main Menu");
	
	//Create labels, buttons, and textfield for the Dice Roll Scene
	private Label lblTitleDice = new Label("DM Playtest Toolkit: Dice Roller");
	private Button btD4 = new Button("D4");
	private Button btD6 = new Button("D6");
	private Button btD8 = new Button("D8");
	private Button btD10 = new Button("D10");
	private Button btD12 = new Button("D12");
	private Button btD20 = new Button("D20");
	private Label lblDiceResult = new Label("Result");
	private TextField tfDiceResult = new TextField();
	private Button btMainFromDice = new Button("Main Menu");
	
	//Create the enemy and set up the hp stat for it
	public int enemyHP = 11;
	
	
	
	//Create Test Scene Stuff
	private TextArea taCombat = new TextArea();
	private Label lblCombatTitle = new Label("DM Playtest Toolkit: Combat Test");
	private Label lblName = new Label("");
	private Label lblStrength = new Label("");
	private Label lblDex = new Label("");
	private Label lblHP = new Label("");
	private Label lblAC = new Label("");
	private Label lblProf = new Label("");
	private Label lblDie = new Label("");
	private Label lblStat = new Label("");
	private Button btImport = new Button("Import Creation");
	private Button btAttack = new Button("Attack");
	private Button btMainFromCombat = new Button("Main Menu");
	//Create variables for the user creation stats
	public int strength = 0;
	public int dex = 0;
	public int hp = 0;
	public int ac = 0;
	public int prof = 0;
	public String die = "";
	public String stat = "";


	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
//MAIN MENU CONTENT
			//create the main gridpane for the main menu and align all the pieces
			GridPane mainPane = new GridPane();
			mainPane.setHgap(5);
			mainPane.setVgap(5);
			mainPane.setPadding(new Insets(20));
			mainPane.add(btCreatorScene, 0, 0);
			mainPane.add(btDiceScene, 0, 3);
			mainPane.add(btTestScene, 0, 6);
			mainPane.setAlignment(Pos.CENTER);
			GridPane.setHalignment(btCreatorScene, HPos.CENTER);
			GridPane.setHalignment(btDiceScene, HPos.CENTER);
			GridPane.setHalignment(btTestScene, HPos.CENTER);
			
			
			
			BorderPane root = new BorderPane();
			root.setTop(lblTitle);
			BorderPane.setAlignment(lblTitle, Pos.CENTER);
			root.setCenter(mainPane);
			
			
			
			
//CREATOR SCENE CONTENT
			
	
			//Create the choiceboxes with values from 1-20 for the 6 different stats
			cbStrength.getItems().add("1"); cbStrength.getItems().add("2"); cbStrength.getItems().add("3"); cbStrength.getItems().add("4");
			cbStrength.getItems().add("5"); cbStrength.getItems().add("6"); cbStrength.getItems().add("7"); cbStrength.getItems().add("8");
			cbStrength.getItems().add("9"); cbStrength.getItems().add("10"); cbStrength.getItems().add("11"); cbStrength.getItems().add("12");
			cbStrength.getItems().add("13"); cbStrength.getItems().add("14"); cbStrength.getItems().add("15"); cbStrength.getItems().add("16");
			cbStrength.getItems().add("17"); cbStrength.getItems().add("18"); cbStrength.getItems().add("19"); cbStrength.getItems().add("20");
			
			cbDex.getItems().add("1"); cbDex.getItems().add("2"); cbDex.getItems().add("3"); cbDex.getItems().add("4");
			cbDex.getItems().add("5"); cbDex.getItems().add("6"); cbDex.getItems().add("7"); cbDex.getItems().add("8");
			cbDex.getItems().add("9"); cbDex.getItems().add("10"); cbDex.getItems().add("11"); cbDex.getItems().add("12");
			cbDex.getItems().add("13"); cbDex.getItems().add("14"); cbDex.getItems().add("15"); cbDex.getItems().add("16");
			cbDex.getItems().add("17"); cbDex.getItems().add("18"); cbDex.getItems().add("19"); cbDex.getItems().add("20");
			
			cbCon.getItems().add("1"); cbCon.getItems().add("2"); cbCon.getItems().add("3"); cbCon.getItems().add("4");
			cbCon.getItems().add("5"); cbCon.getItems().add("6"); cbCon.getItems().add("7"); cbCon.getItems().add("8");
			cbCon.getItems().add("9"); cbCon.getItems().add("10"); cbCon.getItems().add("11"); cbCon.getItems().add("12");
			cbCon.getItems().add("13"); cbCon.getItems().add("14"); cbCon.getItems().add("15"); cbCon.getItems().add("16");
			cbCon.getItems().add("17"); cbCon.getItems().add("18"); cbCon.getItems().add("19"); cbCon.getItems().add("20");
			
			cbInt.getItems().add("1"); cbInt.getItems().add("2"); cbInt.getItems().add("3"); cbInt.getItems().add("4");
			cbInt.getItems().add("5"); cbInt.getItems().add("6"); cbInt.getItems().add("7"); cbInt.getItems().add("8");
			cbInt.getItems().add("9"); cbInt.getItems().add("10"); cbInt.getItems().add("11"); cbInt.getItems().add("12");
			cbInt.getItems().add("13"); cbInt.getItems().add("14"); cbInt.getItems().add("15"); cbInt.getItems().add("16");
			cbInt.getItems().add("17"); cbInt.getItems().add("18"); cbInt.getItems().add("19"); cbInt.getItems().add("20");
			
			cbWis.getItems().add("1"); cbWis.getItems().add("2"); cbWis.getItems().add("3"); cbWis.getItems().add("4");
			cbWis.getItems().add("5"); cbWis.getItems().add("6"); cbWis.getItems().add("7"); cbWis.getItems().add("8");
			cbWis.getItems().add("9"); cbWis.getItems().add("10"); cbWis.getItems().add("11"); cbWis.getItems().add("12");
			cbWis.getItems().add("13"); cbWis.getItems().add("14"); cbWis.getItems().add("15"); cbWis.getItems().add("16");
			cbWis.getItems().add("17"); cbWis.getItems().add("18"); cbWis.getItems().add("19"); cbWis.getItems().add("20");
			
			cbChar.getItems().add("1"); cbChar.getItems().add("2"); cbChar.getItems().add("3"); cbChar.getItems().add("4");
			cbChar.getItems().add("5"); cbChar.getItems().add("6"); cbChar.getItems().add("7"); cbChar.getItems().add("8");
			cbChar.getItems().add("9"); cbChar.getItems().add("10"); cbChar.getItems().add("11"); cbChar.getItems().add("12");
			cbChar.getItems().add("13"); cbChar.getItems().add("14"); cbChar.getItems().add("15"); cbChar.getItems().add("16");
			cbChar.getItems().add("17"); cbChar.getItems().add("18"); cbChar.getItems().add("19"); cbChar.getItems().add("20");
			
			//Create the choice box for the proficency bonus
			cbProf.getItems().add("2"); cbProf.getItems().add("3"); cbProf.getItems().add("4"); cbProf.getItems().add("5");
			cbProf.getItems().add("6");
			
		
			//Create the gridpane with labels and textfields and the choiceboxes in a readable format
			GridPane gpCreator = new GridPane();
			gpCreator.setHgap(5);
			gpCreator.setVgap(5);
			gpCreator.add(new Label("Name:"), 0, 0);
			gpCreator.add(tfName, 1, 0);
			gpCreator.add(new Label("Stats (Uses 5e stats)"), 0, 1);
			gpCreator.add(new Label("Strength (1-20):"), 0, 2);
			gpCreator.add(cbStrength, 1, 2);
			gpCreator.add(new Label("Dexterity (1-20):"), 0, 3);
			gpCreator.add(cbDex, 1, 3);
			gpCreator.add(new Label("Constitution (1-20):"), 0, 4);
			gpCreator.add(cbCon, 1, 4);
			gpCreator.add(new Label("Intelligence (1-20):"), 0, 5);
			gpCreator.add(cbInt, 1, 5);
			gpCreator.add(new Label("Wisdom (1-20):"), 0, 6);
			gpCreator.add(cbWis, 1, 6);
			gpCreator.add(new Label("Charisma (1-20):"), 0, 7);
			gpCreator.add(cbChar, 1, 7);
			gpCreator.add(new Label("HP:"), 3, 2);
			gpCreator.add(tfHP, 4, 2);
			gpCreator.add(new Label("AC:"), 3, 3);
			gpCreator.add(tfAC, 4, 3);
			gpCreator.add(new Label("Speed:"), 3, 4);
			gpCreator.add(tfSpd, 4, 4);
			gpCreator.add(new Label("Size:"), 3, 5);
			gpCreator.add(tfSize, 4, 5);
			gpCreator.add(new Label("Level:"), 3, 6);
			gpCreator.add(tfLvl, 4, 6);
			gpCreator.add(new Label("Proficiency Bonus:"), 3, 7);
			gpCreator.add(cbProf, 4, 7);
			gpCreator.add(new Label("Create Attack: \nFirst Select Die to Use then Stat"), 0, 8);
			gpCreator.add(rbD4, 0, 9);
			gpCreator.add(rbD6, 1, 9);
			gpCreator.add(rbD8, 2, 9);
			gpCreator.add(rbD10, 3, 9);
			gpCreator.add(rbD12, 4, 9);
			gpCreator.add(rbStrength, 0, 10);
			gpCreator.add(rbDex, 1, 10);
			gpCreator.add(btTestToHit, 0, 11);
			gpCreator.add(tfTestToHit, 4, 11);
			gpCreator.add(btTestAttack, 0, 12);
			gpCreator.add(tfTestAttack, 4, 12);
			gpCreator.add(btMainFromCreator, 0, 13);
			gpCreator.add(btSave, 4, 13);	
			
			//Create the BorderPane for the Creator scene and place the gridpane and the title
			BorderPane bpCreator = new BorderPane();
			bpCreator.setTop(lblTitleCreator);
			BorderPane.setAlignment(lblTitleCreator, Pos.CENTER);
			bpCreator.setCenter(gpCreator);
			
			
			//Align the grid and the elements in it
			gpCreator.setAlignment(Pos.CENTER);
			tfName.setAlignment(Pos.BOTTOM_RIGHT);
			tfHP.setAlignment(Pos.BOTTOM_RIGHT);
			tfAC.setAlignment(Pos.BOTTOM_RIGHT);
			tfSpd.setAlignment(Pos.BOTTOM_RIGHT);
			tfSize.setAlignment(Pos.BOTTOM_RIGHT);
			tfLvl.setAlignment(Pos.BOTTOM_RIGHT);
			final ToggleGroup tgDice = new ToggleGroup();
			final ToggleGroup tgStat = new ToggleGroup();
			Insets insets = new Insets(10, 50, 10, -50);
			rbD4.setToggleGroup(tgDice);
			rbD6.setToggleGroup(tgDice);
			rbD8.setToggleGroup(tgDice);
			rbD10.setToggleGroup(tgDice);
			rbD12.setToggleGroup(tgDice);
			rbStrength.setToggleGroup(tgStat);
			rbDex.setToggleGroup(tgStat);
			rbD8.setPadding(insets);
			tfTestToHit.setEditable(false);
			tfTestToHit.setAlignment(Pos.BOTTOM_RIGHT);
			tfTestAttack.setEditable(false);
			tfTestAttack.setAlignment(Pos.BOTTOM_RIGHT);
			GridPane.setHalignment(btMainFromCreator, HPos.LEFT);
			GridPane.setHalignment(btSave, HPos.RIGHT);
			gpCreator.setPadding(new Insets(10, 10, 10, 10));
			
			//Create the button action to Test whether the attack would hit or not based on Proficiency and radio buttons
			btTestToHit.setOnAction(e -> {
				//Create the ToHit variable
				int toHit = 0;
				
				//Use if-else-if to change the value of toHit based on user selection
				
				//Pull the Stat the user has selected 
				RadioButton rbStat = (RadioButton)tgStat.getSelectedToggle();

				//Call the D20Roll method and add the result to the toHit variable
				toHit += D20Roll();
				
				//Determine what Stat was selected and add the modifier based on user selected choice box to toHit
				if (rbStat.getText().equals("Strength")) {
					if (cbStrength.getValue().equals("1")) {
						toHit -= 5;
					} else if (cbStrength.getValue().equals("2") || cbStrength.getValue().equals("3")) {
						toHit -= 4;
					} else if (cbStrength.getValue().equals("4") || cbStrength.getValue().equals("5")) {
						toHit -= 3;
					} else if (cbStrength.getValue().equals("6") || cbStrength.getValue().equals("7")) {
						toHit -= 2;
					} else if (cbStrength.getValue().equals("8") || cbStrength.getValue().equals("9")) {
						toHit -= 1;
					} else if (cbStrength.getValue().equals("10") || cbStrength.getValue().equals("11")) {
						toHit += 0;
					} else if (cbStrength.getValue().equals("12") || cbStrength.getValue().equals("13")) {
						toHit += 1;
					} else if (cbStrength.getValue().equals("14") || cbStrength.getValue().equals("15")) {
						toHit += 2;
					} else if (cbStrength.getValue().equals("16") || cbStrength.getValue().equals("17")) {
						toHit += 3;
					} else if (cbStrength.getValue().equals("18") || cbStrength.getValue().equals("19")) {
						toHit += 4;
					} else if (cbStrength.getValue().equals("20")) {
						toHit += 5;
					} else {
						tfTestAttack.setText("No Stat Selected");
					}
				} else if (rbStat.getText().equals("Dexterity")) {
					if (cbDex.getValue().equals("1")) {
						toHit -= 5;
					} else if (cbDex.getValue().equals("2") || cbDex.getValue().equals("3")) {
						toHit -= 4;
					} else if (cbDex.getValue().equals("4") || cbDex.getValue().equals("5")) {
						toHit -= 3;
					} else if (cbDex.getValue().equals("6") || cbDex.getValue().equals("7")) {
						toHit -= 2;
					} else if (cbDex.getValue().equals("8") || cbDex.getValue().equals("9")) {
						toHit -= 1;
					} else if (cbDex.getValue().equals("10") || cbDex.getValue().equals("11")) {
						toHit += 0;
					} else if (cbDex.getValue().equals("12") || cbDex.getValue().equals("13")) {
						toHit += 1;
					} else if (cbDex.getValue().equals("14") || cbDex.getValue().equals("15")) {
						toHit += 2;
					} else if (cbDex.getValue().equals("16") || cbDex.getValue().equals("17")) {
						toHit += 3;
					} else if (cbDex.getValue().equals("18") || cbDex.getValue().equals("19")) {
						toHit += 4;
					} else if (cbDex.getValue().equals("20")) {
						toHit += 5;
					} else {
						tfTestAttack.setText("No Stat Selected");
					}
				}
				
				//Determine what Proficiency Bonus was selected and add to toHit
				if (cbProf.getValue().equals("2")) {
				toHit += 2;
				} else if (cbProf.getValue().equals("3")) {
				toHit += 3;
				} else if (cbProf.getValue().equals("4")) {
				toHit += 4;
				} else if (cbProf.getValue().equals("5")) {
				toHit += 5;
				} else if (cbProf.getValue().equals("6")) {
				toHit += 6;
				}
				
				//Change the textfield to show the final total of toHit
				tfTestToHit.setText(Integer.toString(toHit));
			});
			
			
			//Create the button action to Test the Attack for the user based on the radiobuttons selected
			btTestAttack.setOnAction(e -> {
				//Create the attack variable
				int attack = 0;
				
				//Use if-else-if to change the value of attack based on user selection
				
				//Pull the Die the user has selected
				RadioButton rbDie = (RadioButton)tgDice.getSelectedToggle();
				//Pull the Stat the user has selected
				RadioButton rbStat = (RadioButton)tgStat.getSelectedToggle();
				
				//Determine what Die was selected then call the method and add to attack
				if(rbDie.getText().equals("D4")) {
					attack += D4Roll();
				} else if (rbDie.getText().equals("D6")) {
					attack += D6Roll();
				} else if (rbDie.getText().equals("D8")) {
					attack += D8Roll();
				} else if (rbDie.getText().equals("D10")) {
					attack += D10Roll();
				} else if (rbDie.getText().equals("D12")) {
					attack += D12Roll();
				} else  {
					tfTestAttack.setText("No Die Selected");
				}
				//Determine what Stat was selected and add the modifier based on user selected choice box to attack
				if (rbStat.getText().equals("Strength")) {
					if (cbStrength.getValue().equals("1")) {
						attack -= 5;
					} else if (cbStrength.getValue().equals("2") || cbStrength.getValue().equals("3")) {
						attack -= 4;
					} else if (cbStrength.getValue().equals("4") || cbStrength.getValue().equals("5")) {
						attack -= 3;
					} else if (cbStrength.getValue().equals("6") || cbStrength.getValue().equals("7")) {
						attack -= 2;
					} else if (cbStrength.getValue().equals("8") || cbStrength.getValue().equals("9")) {
						attack -= 1;
					} else if (cbStrength.getValue().equals("10") || cbStrength.getValue().equals("11")) {
						attack += 0;
					} else if (cbStrength.getValue().equals("12") || cbStrength.getValue().equals("13")) {
						attack += 1;
					} else if (cbStrength.getValue().equals("14") || cbStrength.getValue().equals("15")) {
						attack += 2;
					} else if (cbStrength.getValue().equals("16") || cbStrength.getValue().equals("17")) {
						attack += 3;
					} else if (cbStrength.getValue().equals("18") || cbStrength.getValue().equals("19")) {
						attack += 4;
					} else if (cbStrength.getValue().equals("20")) {
						attack += 5;
					} else {
						tfTestAttack.setText("No Stat Selected");
					}
				} else if (rbStat.getText().equals("Dexterity")) {
					if (cbDex.getValue().equals("1")) {
						attack -= 5;
					} else if (cbDex.getValue().equals("2") || cbDex.getValue().equals("3")) {
						attack -= 4;
					} else if (cbDex.getValue().equals("4") || cbDex.getValue().equals("5")) {
						attack -= 3;
					} else if (cbDex.getValue().equals("6") || cbDex.getValue().equals("7")) {
						attack -= 2;
					} else if (cbDex.getValue().equals("8") || cbDex.getValue().equals("9")) {
						attack -= 1;
					} else if (cbDex.getValue().equals("10") || cbDex.getValue().equals("11")) {
						attack += 0;
					} else if (cbDex.getValue().equals("12") || cbDex.getValue().equals("13")) {
						attack += 1;
					} else if (cbDex.getValue().equals("14") || cbDex.getValue().equals("15")) {
						attack += 2;
					} else if (cbDex.getValue().equals("16") || cbDex.getValue().equals("17")) {
						attack += 3;
					} else if (cbDex.getValue().equals("18") || cbDex.getValue().equals("19")) {
						attack += 4;
					} else if (cbDex.getValue().equals("20")) {
						attack += 5;
					} else {
						tfTestAttack.setText("No Stat Selected");
					}
				}
				//Change the textfield to show the final total of attack
				tfTestAttack.setText(Integer.toString(attack)); 
			});
			
			//Create the button action to save to a text file and write all the user input into it
			btSave.setOnAction((ActionEvent event) -> {
				
				//Create RadioButtons to pull the text from the 2 toggle groups
				//Pull the Die the user has selected
				RadioButton rbDie = (RadioButton)tgDice.getSelectedToggle();
				//Pull the Stat the user has selected
				RadioButton rbStat = (RadioButton)tgStat.getSelectedToggle();
				
				//Create a string containing all user selected input
				String content ="Name: " + tfName.getText() + "\n" + "Stats\nStrength: " + cbStrength.getValue() + "\nDexterity: " 
						+ cbDex.getValue() + "\nConstitution: " + cbCon.getValue() + "\nIntelligence: " + cbInt.getValue() + "\nWisdom: "
						+ cbWis.getValue() + "\nCharisma: " + cbChar.getValue() + "\nHP: " +tfHP.getText() + "\nAC: "
						+ tfAC.getText() + "\nSpeed: " + tfSpd.getText() + "\nSize: " + tfSize.getText() + "\nLevel: "
						+ tfLvl.getText() + "\nProficiency Bonus: " + cbProf.getValue() + "\nDie Used: " + rbDie.getText()
						+ "\nStat Used: " + rbStat.getText();
				//Create a filechooser to open the save screen
				FileChooser save = new FileChooser();
				save.setTitle("Save");
				save.setInitialFileName("Creation.txt");
				save.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Files", "*.*"));
				File file = save.showSaveDialog(primaryStage);
				
				//If the file isnt null then save the String content to the file as designated by the user
				if(file != null) {
					try {
						SaveFile(content, file);
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				}
			});
			
			
//DICE ROLL SCENE CONTENT
			
			
			//Create the gridpane for the centerpane of the BorderPane
			GridPane gpDice = new GridPane();
			gpDice.setHgap(5);
			gpDice.setVgap(5);
			gpDice.setPadding(new Insets(10));
			gpDice.add(btD4, 0, 0);
			gpDice.add(btD6, 1, 0);
			gpDice.add(btD8, 0, 1);
			gpDice.add(btD10, 1, 1);
			gpDice.add(btD12, 0, 2);
			gpDice.add(btD20, 1, 2);
			
			//Create the gridpane for the bottom pane of the BorderPane
			GridPane gpDiceBot = new GridPane();
			gpDiceBot.setHgap(5);
			gpDiceBot.setVgap(5);
			gpDiceBot.setPadding(new Insets(10));
			gpDiceBot.add(lblDiceResult, 0, 0);
			gpDiceBot.add(tfDiceResult, 0, 1);
			gpDiceBot.add(btMainFromDice, 0, 2);
			
			//Set up the BorderPane for the DiceRoller Scene
			BorderPane bpDice = new BorderPane();
			bpDice.setTop(lblTitleDice);
			bpDice.setCenter(gpDice);
			bpDice.setBottom(gpDiceBot);
			
			//Align all the panes and elements of them
			BorderPane.setAlignment(lblTitleDice, Pos.CENTER);
			gpDice.setAlignment(Pos.CENTER);
			gpDiceBot.setAlignment(Pos.CENTER);
			GridPane.setHalignment(btD4, HPos.CENTER);
			GridPane.setHalignment(btD6, HPos.CENTER);
			GridPane.setHalignment(btD8, HPos.CENTER);
			GridPane.setHalignment(btD10, HPos.CENTER);
			GridPane.setHalignment(btD12, HPos.CENTER);
			GridPane.setHalignment(btD20, HPos.CENTER);
			GridPane.setHalignment(btMainFromDice, HPos.CENTER);
			GridPane.setHalignment(lblDiceResult, HPos.CENTER);
			GridPane.setHalignment(tfDiceResult, HPos.CENTER);
			//Set up the textfield to display a result in the center
			tfDiceResult.setMaxWidth(50);
			tfDiceResult.setAlignment(Pos.CENTER);
			tfDiceResult.setEditable(false);
			
			//Set all the buttons to roll a dice to the corresponding number by calling the methods of the dice
			btD4.setOnAction((ActionEvent event) -> {
					tfDiceResult.setText(Integer.toString(D4Roll()));
			});
			btD6.setOnAction((ActionEvent event) -> {
					tfDiceResult.setText(Integer.toString(D6Roll()));
			});
			btD8.setOnAction((ActionEvent event) -> {
					tfDiceResult.setText(Integer.toString(D8Roll()));
			});
			btD10.setOnAction((ActionEvent event) -> {
					tfDiceResult.setText(Integer.toString(D10Roll()));
			});
			btD12.setOnAction((ActionEvent event) -> {
					tfDiceResult.setText(Integer.toString(D12Roll()));
			});
			btD20.setOnAction((ActionEvent event) -> {
					tfDiceResult.setText(Integer.toString(D20Roll()));
			});
			
//TEST COMBAT SCENE CONTENT
			
			//Create the gridpane for the center of the BorderPane with all the elements displayed there 
			GridPane gpCombat = new GridPane();
			gpCombat.setHgap(5);
			gpCombat.setVgap(5);
			gpCombat.setPadding(new Insets(10));
			gpCombat.add(new Label("Name: Bandit"), 0, 0);
			gpCombat.add(new Label("Stats (Uses 5e stats)"), 0, 1);
			gpCombat.add(new Label("Strength: 11"), 0, 2);
			gpCombat.add(new Label("Dexterity: 12"), 0, 3);
			gpCombat.add(new Label("Constitution: 12"), 0, 4);
			gpCombat.add(new Label("Intelligence: 10"), 0, 5);
			gpCombat.add(new Label("Wisdom: 10"), 0, 6);
			gpCombat.add(new Label("Charisma: 10"), 0, 7);
			gpCombat.add(new Label("HP: 11"), 1, 2);
			gpCombat.add(new Label("AC: 12"), 1, 3);
			gpCombat.add(new Label("Speed: 30ft"), 1, 4);
			gpCombat.add(new Label("Size: Medium"), 1, 5);
			gpCombat.add(new Label("Challenge Rating: 1/8"), 1, 6);
			gpCombat.add(new Label("Proficiency Bonus: +2"), 1, 7);
			gpCombat.add(btImport, 0, 8);
			gpCombat.add(lblName, 0, 9);
			gpCombat.add(lblStrength, 0, 10);
			gpCombat.add(lblDex, 1, 10);
			gpCombat.add(lblHP, 0, 11);
			gpCombat.add(lblAC, 1, 11);
			gpCombat.add(lblProf, 0, 12);
			gpCombat.add(lblDie, 0, 13);
			gpCombat.add(lblStat, 1, 13);
			gpCombat.add(btAttack, 1, 15);
			gpCombat.add(taCombat, 0, 15);
			
			
			//Set up the BorderPane for the Combat Test Scene
			BorderPane bpCombat = new BorderPane();
			bpCombat.setTop(lblCombatTitle);
			bpCombat.setCenter(gpCombat);
			bpCombat.setBottom(btMainFromCombat);
			BorderPane.setMargin(btMainFromCombat, new Insets(-5, 10, 10, 10));
			
			//Align all the panes for the Combat Test scene and the elements of them
			BorderPane.setAlignment(lblCombatTitle, Pos.CENTER);
			gpCombat.setAlignment(Pos.CENTER);
			GridPane.setHalignment(taCombat, HPos.CENTER);
			taCombat.setMaxWidth(300);
			taCombat.setEditable(false);
			BorderPane.setAlignment(btMainFromCombat, Pos.BOTTOM_LEFT);
			
			
			//Set up the import button to pull information from a text file
			btImport.setOnAction((ActionEvent event) -> {
				FileChooser creation = new FileChooser();
				creation.setTitle("Import");
				creation.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Files", "*.*"));
				File file = creation.showOpenDialog(primaryStage);
				
				if (file != null) {
					try {
						//Reads the lines for specific string contents
						List<String> lines = Files.readAllLines(file.toPath());
						for (String line: lines) {
							if (line.contains("Name: ")) {
								//displays the string contents
								lblName.setText(line.split(":")[1].strip());
							} else if (line.contains("Strength: ")) {
								lblStrength.setText(line);
								int uStrength = Integer.parseInt(line.split(":")[1].strip()); //takes the string and converts the number to an int
								strength = uStrength; 										  //assigns that int to a variable
							} else if (line.contains("Dexterity: ")) {
								lblDex.setText(line);
								int uDex = Integer.parseInt(line.split(":")[1].strip());
								dex = uDex;
							} else if (line.contains("HP: ")) {
								lblHP.setText(line);
								int uHP = Integer.parseInt(line.split(":")[1].strip());
								hp = uHP;
							} else if (line.contains("AC: ")) {
								lblAC.setText(line);
								int uAC = Integer.parseInt(line.split(":")[1].strip());
								ac = uAC;
							} else if (line.contains("Proficiency Bonus: ")) {
								lblProf.setText(line);
								int uProf = Integer.parseInt(line.split(":")[1].strip());
								prof = uProf;
							} else if (line.contains("Die Used: ")) {
								lblDie.setText(line);
								String uDie = line.split(":")[1].strip();
								die = uDie;
							} else if (line.contains("Stat Used: ")) {
								lblStat.setText(line);
								String uStat = line.split(":")[1].strip();
								stat = uStat;
							}
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
			});
			
			//initializes the attack action pulling the variables from the document into it
			btAttack.setOnAction(e -> Attack(strength, dex, hp, ac, prof, die, stat, enemyHP));
			
			
//Create all the scenes for the app then set the mainscene as the starting scene
			Scene mainScene = new Scene(root, 200, 225);
			Scene creatorScene = new Scene(bpCreator);
			Scene diceScene = new Scene(bpDice, 200, 225);
			Scene testScene = new Scene(bpCombat);
			primaryStage.setScene(mainScene);
			primaryStage.show();
			
			//Set up the buttons to switch the scenes
			btCreatorScene.setOnAction(e -> primaryStage.setScene(creatorScene));
			btDiceScene.setOnAction(e -> primaryStage.setScene(diceScene));
			btTestScene.setOnAction(e -> primaryStage.setScene(testScene));
			btMainFromCreator.setOnAction(e -> primaryStage.setScene(mainScene));
			btMainFromDice.setOnAction(e -> primaryStage.setScene(mainScene));
			btMainFromCombat.setOnAction(e -> primaryStage.setScene(mainScene));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	
		
	}
	

	//Set up the D4 dice roller
	private int D4Roll() {
		int d4Value;
		final int d4Max = 4;
			//we use Random to determine the roll
			d4Value = (int)(Math.random() * d4Max) + 1;
		return d4Value;
	}
	//Set up the D6 dice roller
	private int D6Roll() {
		int d6Value;
		final int d6Max = 6;
			//we use Random to determine the roll
			d6Value = (int)(Math.random() * d6Max) + 1;
		return d6Value;
	}
	//Set up the D8 dice roller
	private int D8Roll() {
		int d8Value;
		final int d8Max = 8;
			//we use Random to determine the roll
			d8Value = (int)(Math.random() * d8Max) + 1;
		return d8Value;
	}
	//Set up the D10 dice roller
	private int D10Roll() {
		int d10Value;
		final int d10Max = 10;
			//we use Random to determine the roll
			d10Value = (int)(Math.random() * d10Max) + 1;
		return d10Value;
	}
	//Set up the D12 dice roller
	private int D12Roll() {
		int d12Value;
		final int d12Max = 12;
			//we use Random to determine the roll
			d12Value = (int)(Math.random() * d12Max) + 1;
		return d12Value;
	}
	//Set up the D20 dice roller
	private int D20Roll() {
		int d20Value;
		final int d20Max = 20;
			//we use Random to determine the roll	
			d20Value = (int)(Math.random() * d20Max) + 1;
		return d20Value;
	}


	//This saves the user input to a text
	public void SaveFile(String content, File file) throws IOException {
		
			FileWriter fileWriter;
			fileWriter = new FileWriter(file);
			//write the string content to the file then close it
			fileWriter.write(content);
			fileWriter.close();
		
	}
	
	//Set up the attack action
	public void Attack(int strength, int dex, int hp, int ac, int prof, String die, String stat, int enemyHP) {
		//Set up the basic enemy hp, ac, toHit, and attack variables
		int enemyAC = 12;
		int enemyToHit = 0;
		int enemyAttack = 0;
		
		
		
		//Set up the users toHit, attack and mod variables
		int toHit = 0;
		int attack = 0;
		int mod = 0;
		
		 //Roll the attack from the D20Roll and add mod + proficiency
		if (stat.equals("Strength")) {
			
			//Then discover the modifier based on the stat and add it to mod
			if (strength == 1) {
				mod -= 5;
			} else if (strength == 2 || strength == 3) {
				mod -= 4;
			} else if (strength == 4 || strength == 5) {
				mod -= 3;
			} else if (strength == 6 || strength == 7) {
				mod -= 2;
			} else if (strength == 8 || strength == 9) {
				mod -= 1;
			} else if (strength == 10 || strength == 11) {
				mod += 0;
			}  else if (strength == 12 || strength == 13) {
				mod += 1;
			}  else if (strength == 14 || strength == 15) {
				mod += 2;
			}  else if (strength == 16 || strength == 17) {
				mod += 3;
			}  else if (strength == 18 || strength == 19) {
				mod += 4;
			} else if (strength == 20) {
				mod += 5;
			}
					
		} else if (stat.equals("Dexterity")) {
					
			//Then discover the modifier based on the stat and add it to mod
			if (dex == 1) {
				mod -= 5;
			} else if (dex == 2 || dex == 3) {
				mod -= 4;
			} else if (dex == 4 || dex == 5) {
				mod -= 3;
			} else if (dex == 6 || dex == 7) {
				mod -= 2;
			} else if (dex == 8 || dex == 9) {
				mod -= 1;
			} else if (dex == 10 || dex == 11) {
				mod += 0;
			}  else if (dex == 12 || dex == 13) {
				mod += 1;
			}  else if (dex == 14 || dex == 15) {
				mod += 2;
			}  else if (dex == 16 || dex == 17) {
				mod += 3;
			}  else if (dex == 18 || dex == 19) {
				mod += 4;
			} else if (dex == 20) {
					mod += 5;
			}
		}
		//Roll the user toHit roll and see if its equal to or higher than enemy ac
		toHit = D20Roll() + mod + prof;
		
		if (toHit >= enemyAC) {
			//display what the roll was to hit for the user
			taCombat.appendText("Roll to hit was: " + toHit + " which hits!\n");
			//If the toHit roll is higher than or equal to the enemyAC then the attack hits. at that point we roll the damage done
			if (die.equals("D4")) {
				attack = D4Roll() + mod; //We roll the corresponding die and add only the modifier to the roll to determine damage
				//display the damage done to the user
				taCombat.appendText("Damage done: " + attack + "\n");
			} else if (die.equals("D6")) {
				attack = D6Roll() + mod;
				taCombat.appendText("Damage done: " + attack + "\n");
			} else if (die.equals("D8")) {
				attack = D8Roll() + mod;
				taCombat.appendText("Damage done: " + attack + "\n");
			} else if (die.equals("D10")) {
				attack = D10Roll() + mod;
				taCombat.appendText("Damage done: " + attack + "\n");
			} else if (die.equals("D12")) {
				attack = D12Roll() + mod;
				taCombat.appendText("Damage done: " + attack + "\n");
			}
		} else {
			taCombat.appendText("Roll to hit was: " + toHit + " which misses!\n");
		}
		//Now we subtract the damage done from the enemy health and see if the enemy still lives by calling another method
		enemyHP = EnemyHPTotal(attack);

		//If they still live we display that to the user
		if (enemyHP > 0) {
			taCombat.appendText("Enemy HP: " + enemyHP + "\n");
		} else {
		//If not we show that as well
			taCombat.appendText("Enemy Defeated! Congrats!\n");
		}
		
		//We then have the enemy attack and see if they hit the user creation by calling the D20Roll method
		enemyToHit = D20Roll() + 3;
		if (enemyToHit >= ac) {
			taCombat.appendText("Enemy hits with a " + enemyToHit + "\n");
			//If it hits we then roll the damage
			enemyAttack = D6Roll() + 1;
			taCombat.appendText("Damage to you is " + enemyAttack + "\n");
		} else {
			taCombat.appendText("Enemy misses with a " + enemyToHit + "\n");
		}
		
		//if the enemy hit we subtract the damage from the hp of user creation by calling another method
		hp = HPTotal(enemyAttack);
		
		if (hp > 0) {
			//display the results from the attack to the user
			taCombat.appendText("Your HP: " + hp + "\n");
		} else {
			taCombat.appendText("You have been defeated! Better luck next time\n");
		}
		taCombat.appendText("\n");
	}

	//this method is what determines how much the users creation has left
	private int HPTotal(int enemyAttack) {
		hp -= enemyAttack;
		return hp;
	}
	//this method is what determines how much health the enemy has left
	private int EnemyHPTotal(int attack) {
		enemyHP -= attack;
		return enemyHP;
	}


	//Launch the application
	public static void main(String[] args) {
		launch(args);
	}
}
