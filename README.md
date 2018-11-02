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

For our code no special runconfig is needed, however jade and waka must be imported, and java version must be set to 1.7 (generaly homeagent will have a error that prompts to fix this) after these have been done the code can be run directly through the main controller

**How to run specific scenarios**

For this application the scenarios have been provided as click buttons in the setting menu on the right hand side. Just chick the relevent one you which to test.
