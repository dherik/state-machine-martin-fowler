package io.github.dherik;

import io.github.dherik.commands.LockDoor;
import io.github.dherik.commands.LockPanel;
import io.github.dherik.commands.UnlockDoor;
import io.github.dherik.commands.UnlockPanel;
import io.github.dherik.events.DoorClosed;
import io.github.dherik.events.DrawerOpened;
import io.github.dherik.events.LightOn;
import io.github.dherik.events.PanelClosed;
import io.github.dherik.states.Active;
import io.github.dherik.states.Idle;
import io.github.dherik.states.UnlockedPanel;
import io.github.dherik.states.WaitingForDrawer;
import io.github.dherik.states.WaitingForLight;

class BasicStateMachine /*extends StateMachineBuilder*/ {

    //Events doorClosed, drawerOpened, lightOn, panelClosed;
    private DoorClosed doorClosed;
    private DrawerOpened drawerOpened;
    private LightOn lightOn;
    private PanelClosed panelClosed;

    //Commands unlockPanel, lockPanel, lockDoor, unlockDoor;
    private UnlockPanel unlockPanel;
    private LockPanel lockPanel;
    private LockDoor lockDoor;
    private UnlockDoor unlockDoor;

    //States idle, active, waitingForLight, waitingForDrawer, unlockedPanel;
    private Idle idle;
    private Active active;
    private WaitingForLight waitingForLight;
    private WaitingForDrawer waitingForDrawer;
    private UnlockedPanel unlockedPanel;

//	ResetEvents doorOpened;
    protected void defineStateMachine() {
        doorClosed.code("D1CL");
        drawerOpened.code("D2OP");
        lightOn.code("L1ON");
        panelClosed.code("PNCL");

//      doorOpened.code("D1OP");
        unlockPanel.code("PNUL");
        lockPanel.code("PNLK");
        lockDoor.code("D1LK");
        unlockDoor.code("D1UL");

        idle.actions(unlockDoor, lockPanel).transition(doorClosed).to(active);

        active
                .transition(drawerOpened).to(waitingForLight)
                .transition(lightOn).to(waitingForDrawer);

        waitingForLight.transition(lightOn).to(unlockedPanel);

        waitingForDrawer.transition(drawerOpened).to(unlockedPanel);

        unlockedPanel
                .actions(unlockPanel, lockDoor).transition(panelClosed)
                .to(idle);

    }
}
