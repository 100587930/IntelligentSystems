**IntelligentSystems**

intelligent systems group lab 1

**How the codebase is structured**

[https://i.imgur.com/DgMIcWq.png](https://i.imgur.com/DgMIcWq.png)

Src▼

    ►Agents▼

                  ApplianceAgent.java

                  HomeAgent.java

                  RetailerAgent.java

    ►behaviours▼

                  ApplianceCyclicBehaviour.java

                  ApplianceTickerBehaviour.java

                  HomeCyclicBehaviours.java

                  RetailerCyclicBehaviours.java

    ►controllers▼

                  MainController.java

    ►Gui▼

                  gui.java

                  Model.java

                  SettingModel.java

                  SettingView.java

                  View.java

    ►main▼

                  Main.java

    ►models▼

                  Appliance.java

                  EnergyOffer.java

                  Retailer.java

    ►tariffs▼

                  FixedTariff.java

                  IncreaseVolumeTariff.java

                  Tariff.java

                  TariffInterface.java

                  VolumeTariff.java

    ►utils▼

                  Constants.java

                  Tariffs.java

                  TariffSwitch.java

**How to build and run the code**

For our code no special runconfig is needed, however jade must be imported, and java version must be set to 1.7 to run

Otherwise just compile through the main class and the code will run

**How to run specific scenarios**

For all the scenarios the user will only have to change the values in the setting menu that first appears when the application is run. These will need to be updated with the provided values in the report
