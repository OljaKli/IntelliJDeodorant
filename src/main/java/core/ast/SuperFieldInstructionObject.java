package core.ast;

import com.intellij.psi.PsiElement;

public class SuperFieldInstructionObject {

    private final String ownerClass;
    private final TypeObject type;
    private final String name;
    private boolean _static;
    private ASTInformation simpleName;
    private volatile int hashCode = 0;

    public SuperFieldInstructionObject(String ownerClass, TypeObject type, String name) {
        this.ownerClass = ownerClass;
        this.type = type;
        this.name = name;
        this._static = false;
    }

    public String getOwnerClass() {
        return ownerClass;
    }

    public TypeObject getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public boolean isStatic() {
        return _static;
    }

    public void setStatic(boolean s) {
        _static = s;
    }

    public void setSimpleName(PsiElement simpleName) {
        this.simpleName = ASTInformationGenerator.generateASTInformation(simpleName);
    }

    public PsiElement getSimpleName() {
        return this.simpleName.recoverASTNode();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o instanceof SuperFieldInstructionObject) {
            SuperFieldInstructionObject sfio = (SuperFieldInstructionObject) o;
            return this.ownerClass.equals(sfio.ownerClass)
                    && this.name.equals(sfio.name)
                    && this.type.equals(sfio.type);
        }
        return false;
    }

    public int hashCode() {
        if (hashCode == 0) {
            int result = 17;
            result = 37 * result + ownerClass.hashCode();
            result = 37 * result + name.hashCode();
            result = 37 * result + type.hashCode();
            hashCode = result;
        }
        return hashCode;
    }

    public String toString() {
        return ownerClass + "::" +
                name;
    }
}
