package gfy.modules

import geb.Module
import geb.navigator.Navigator

class CommonModule extends Module {

    // this is a general use common module for reusing useful methods and more

    /**
     * moves to element and waits for it to be present before performing clicking
     * @param elem
     */
    Navigator moveTo(Navigator elem) {
        interact {
            waitFor { elem }
            moveToElement elem
        }
        elem
    }

    /**
     * moves to element and waits for it to be present before performing clicking
     * @param elem
     */
    void moveClick(Navigator elem) {
        interact {
            waitFor { elem }
            moveToElement elem
            waitFor { elem.size() != 0 }
            click elem
        }
    }

    /**
     * moves to element and waits for it to be present before performing clicking. User given wait preset.
     * @param elem
     */
    void moveClick(String waitPreset, Navigator elem) {
        interact {
            waitFor(waitPreset) { elem }
            moveToElement elem
            waitFor(waitPreset) { elem.size() != 0 }
            click elem
        }
    }

    /**
     * moves to element and waits for it to be present before performing clicking mutiple times
     * @param elem
     */
    void moveClick(Navigator elem, Integer clickAmount) {
        interact {
            waitFor { elem }
            moveToElement elem
            waitFor { elem.size() != 0 }
            clickAmount.times { click elem }
        }
    }
}
