// BindingSite.java
// assists with variable binding.
package wyvern.target.corewyvernIL;

public class BindingSite {
    private static int globalIndex = 0;
    private String name;
    private int index;

    public BindingSite(String name) {
    	// check name validity
        if (name == null || name.length() == 0) {
            throw new RuntimeException("binding name invariant violated");
        }

        index = globalIndex++;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + '_' + index;
    }

    public String getName() {
        return name;
    }
}
