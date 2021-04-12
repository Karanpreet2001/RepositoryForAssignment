package application;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class SampleController implements Initializable{

    @FXML
    private RadioButton rdnAirline;								// radiobutton for airline

    @FXML
    private ToggleGroup AirlineInfo;

    @FXML
    private RadioButton rdnArrAirport;							// radiobutton for Arrival Airport

    @FXML
    private RadioButton rdnDepAirport;							// radiobutton for Departure Airport

    @FXML
    private RadioButton rdnAirlineNo;							// radiobutton for airline Number

    @FXML
    private ChoiceBox<String> cmbAirline;						// Choice box for airline 

    @FXML
    private ChoiceBox<String> cmbAirlineNo;						// Choice box for airline number

    @FXML
    private ChoiceBox<String> cmbDepAirport;					// Choice box for Departure Airport

    @FXML
    private ChoiceBox<String> cmbArrAirport;					// Choice box for Arrival Airport

    @FXML
    private ListView<String> listView;						   // List View

    @FXML
    private Button search;

    @FXML
    private Button close;
    
    
    ArrayList<Airline> arr = new ArrayList<>();									// arraylist to store the values inside it
    ArrayList<String> temp = new ArrayList<>();									// temp arraylist is a type of arraylist but it is used temporary.
    String head="Airline    AirlineNo    Departure   Arrival";				  // header of the list
    
    
    // you can change the file content without changing the code it will work

    //this is used to make the radio button rdnAirlineNo event when it is clicked.
    @FXML
    void onClickAirlineNo(ActionEvent event) {

    	
    	listView.getItems().clear();
    	listView.getItems().add(head);
    	
    	cmbAirlineNo.setValue("Select Airline Number");
    	
    	temp.removeAll(temp);
    	
    	ObservableList<String> airlineNoList = FXCollections.observableArrayList();								//ObservableList is used to add the values in the Choice box
    	for(int i = 0; i<arr.size();i++) {
    		if(!temp.contains(arr.get(i).getAirlineNo())) {														// .contains method is used to avoid the duplication of values
    			temp.add(arr.get(i).getAirlineNo());
    			airlineNoList.add(arr.get(i).getAirlineNo());
    		}
    	}
    	cmbAirlineNo.setItems(airlineNoList);																	// setting items inside the cmbAirlineNo combo box
    	
    	// when radiobutton rdnAirlineNo is selected only cmbAirlineNo will be available for Selection.
		cmbAirline.setDisable(true);
		cmbAirlineNo.setDisable(false);
		cmbDepAirport.setDisable(true);
		cmbArrAirport.setDisable(true);
		
    }

  //this is used to make the radio button rdnAirline event when it is clicked.
    @FXML
    void onClickRdnAirline(ActionEvent event) {

    	
    	listView.getItems().clear();
    	listView.getItems().add(head);
    	
    	cmbAirline.setValue("Select Airline");
    	
    	temp.removeAll(temp);
    	
    	ObservableList<String> airlines = FXCollections.observableArrayList();
    	for(int i = 0; i<arr.size();i++) {
    		if(!temp.contains(arr.get(i).getAirline())) {
    			temp.add(arr.get(i).getAirline());
    			airlines.add(arr.get(i).getAirline());
    		}
    	}
    	cmbAirline.setItems(airlines);																	// setting items inside the cmbAirline combo box
    	
    	// when radiobutton rdnAirline is selected only cmbArrAirport will be available for Selection.
		cmbAirline.setDisable(false);
		cmbAirlineNo.setDisable(true);
		cmbDepAirport.setDisable(true);
		cmbArrAirport.setDisable(true);
    }

    
  //this is used to make the radio button rdnArrAirport event when it is clicked.
    @FXML
    void onClickRdnArrAirport(ActionEvent event) {

    	listView.getItems().clear();
    	listView.getItems().add(head);
    	
    	cmbArrAirport.setValue("Select Arrival Airport");
    	
    	temp.removeAll(temp);
    	
    	ObservableList<String> arrAirportList = FXCollections.observableArrayList();
    	for(int i = 0; i<arr.size();i++) {
    		if(!temp.contains(arr.get(i).getArrAirport())) {
    			temp.add(arr.get(i).getArrAirport());
    			arrAirportList.add(arr.get(i).getArrAirport());
    		}
    	}
    	cmbArrAirport.setItems(arrAirportList);																// setting items inside the cmbArrAirport combo box
    	
    	// when radiobutton rdnArrAirport is selected only cmbArrAirport will be available for Selection.
		cmbAirline.setDisable(true);
		cmbAirlineNo.setDisable(true);
		cmbDepAirport.setDisable(true);
		cmbArrAirport.setDisable(false);
    }

    
    //this is used to make the radio button rdnDepAirport event when it is clicked.
    @FXML
    void onClickRdnDepAirport(ActionEvent event) {															// setting items inside the cmbDepAirport combo box

    	
    	listView.getItems().clear();
    	listView.getItems().add(head);
    	
    	cmbDepAirport.setValue("Select Departure Airport");
    	
    	temp.removeAll(temp);
    	
    	ObservableList<String> depAirportList = FXCollections.observableArrayList();						
    	for(int i = 0; i<arr.size();i++) {
    		if(!temp.contains(arr.get(i).getDepAirport())) {
    			temp.add(arr.get(i).getDepAirport());
    			depAirportList.add(arr.get(i).getDepAirport());
    		}
    	}
    	cmbDepAirport.setItems(depAirportList);
    	
    	
    	// when radiobutton rdnDepAirport is selected only cmbdepAirpot will be available for Selection.
		cmbAirline.setDisable(true);
		cmbAirlineNo.setDisable(true);
		cmbDepAirport.setDisable(false);
		cmbArrAirport.setDisable(true);
		
		
    }

    
    //used to exit the application
    @FXML
    void toClose(ActionEvent event) {

    	
    	System.exit(0);											// used to exit the application
    }

    @FXML
    void toSearch(ActionEvent event) {

    	
    	
    	String selectedAirline = cmbAirline.getSelectionModel().getSelectedItem();							// get the selected item from cmbAirline choice box

    	String selectedAirlineNo = cmbAirlineNo.getSelectionModel().getSelectedItem();						// get the selected item from cmbAirlineNo choice box
    	
    	String selectedDepAirport = cmbDepAirport.getSelectionModel().getSelectedItem();					// get the selected item from cmbDepAirport choice box
    	
    	String selectedArrAirport = cmbArrAirport.getSelectionModel().getSelectedItem();					// get the selected item from cmbArrAirport choice box
    	
    	String s;
    	
    	if(cmbAirline.isDisable()==false)
        	if(selectedAirline!=null) {
        	for(int j=0;j<arr.size();j++) {																		//used to compare the value of selectedAirline with arraylist arr
        		if(selectedAirline.equals(arr.get(j).getAirline())) {										   
            		s=arr.get(j).getAirline()+"    "+arr.get(j).getAirlineNo()+"\t  "+arr.get(j).getDepAirport()+"\t  "+arr.get(j).getArrAirport();
            		listView.getItems().add(s);																   // putting the values inside the list View
            		
               }
        	}
        	
        	}
        	
    	
    	if(cmbAirlineNo.isDisable()==false) {
        	if(selectedAirlineNo!=null) {
        		
        	for(int j=0;j<arr.size();j++) {
        		if(selectedAirlineNo.equals(arr.get(j).getAirlineNo())) {											//used to compare the value of selectedAirlineNo with arraylist arr
        			s=arr.get(j).getAirline()+"     "+arr.get(j).getAirlineNo()+"\t  "+arr.get(j).getDepAirport()+"\t  "+arr.get(j).getArrAirport();
        		listView.getItems().add(s);
        		
              }
        		
        	}
        	}
        	}
    	
    	
    	if(cmbDepAirport.isDisable()==false)
        	if(selectedDepAirport!=null) {
        	for(int j=0;j<arr.size();j++) {																			
        		if(selectedDepAirport.equals(arr.get(j).getDepAirport())) {
           		
        			s=arr.get(j).getAirline()+"     "+arr.get(j).getAirlineNo()+"\t  "+arr.get(j).getDepAirport()+"\t  "+arr.get(j).getArrAirport();
        		listView.getItems().add(s);																			// putting the values inside the list View
              }
        		
        	}
        	}
    	
    	if(cmbArrAirport.isDisable()==false)
        	if(selectedArrAirport!=null) {
        	for(int j=0;j<arr.size();j++) {
        		if(selectedArrAirport.equals(arr.get(j).getArrAirport())) {
        			s=arr.get(j).getAirline()+"     "+arr.get(j).getAirlineNo()+"\t  "+arr.get(j).getDepAirport()+"\t  "+arr.get(j).getArrAirport();
        		listView.getItems().add(s);
              }
        		
        	}
        	}
    	
    }

    
    // initization is used to intialised the comntent of the GUI.
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// opening files to read the content.
		FileInputStream input;
		try {
			input = new FileInputStream("C:\\Users\\Karanpreet\\eclipse-workspace\\Assignment_004\\application\\Flight.txt");
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			
			String s = reader.readLine();														// used to read the line
			String[] array= new String[3];
			
			
			while(s != null) {
				array=s.split(",");																// splitting the array into parts and storing it in the temporary variable
				String airline = array[0];
				String airlineNo=array[1];
				String depAirport= array[2];
				String arrAirport= array[3];
				
				arr.add(new Airline(airline,airlineNo,depAirport,arrAirport ));					// arraylist is used to make a lst of the values got fromthe files.
				
				s = reader.readLine();
			}
			
			reader.close();																		//used to close the file
			
			//use to add the header of the listView
			listView.getItems().add(head);
			
			
			// use to help the selector to select the values from Choice boxes - by default it is added in the Initialisation
			cmbAirline.setValue("Select Airline");
			cmbAirlineNo.setValue("Select Airline Number");
			cmbDepAirport.setValue("Select Departure Airport");
			cmbArrAirport.setValue("Select Arrival Airport");
			
			
		} catch (FileNotFoundException e) {


			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	}

}

