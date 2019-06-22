package wyvern.tools.typedAST.core.declarations;

import java.util.List;
import wyvern.target.corewyvernIL.decltype.DeclType;
import wyvern.target.corewyvernIL.decltype.ValDeclType;
import wyvern.target.corewyvernIL.modules.TypedModuleSpec;
import wyvern.target.corewyvernIL.support.GenContext;
import wyvern.target.corewyvernIL.type.ValueType;
import wyvern.tools.errors.ErrorMessage;
import wyvern.tools.errors.FileLocation;
import wyvern.tools.errors.ToolError;
import wyvern.tools.typedAST.abs.Declaration;
import wyvern.tools.typedAST.core.binding.NameBinding;
import wyvern.tools.typedAST.core.binding.NameBindingImpl;
import wyvern.tools.typedAST.interfaces.CoreAST;
import wyvern.tools.typedAST.interfaces.ExpressionAST;
import wyvern.tools.typedAST.interfaces.TypedAST;
import wyvern.tools.typedAST.typedastvisitor.TypedASTVisitor;
import wyvern.tools.types.Type;

public class RecConstructDeclaration extends Declaration implements CoreAST {
	private String name;
	private ExpressionAST body;
    private NameBinding binding;
	private Type declaredType;
    private FileLocation location = FileLocation.UNKNOWN;
    private ValueType cachedValueType;
    
	// constructor
	public RecConstructDeclaration(String name, Type type, TypedAST body, FileLocation location) {
		// debugger
		System.out.println();
		System.out.println("RecConstructDeclaration Called");
        System.out.println("	RecConstruct Name: " + name);
        System.out.println("	RecConstruct Type: " + type);
        System.out.println("	RecConstruct Body: " + body);
        System.out.println("	RecConstruct Location: " + location);
        System.out.println();
        
        // set name
        this.name = name;
        binding = new NameBindingImpl(name, type);
        
        // set body
        this.body = (ExpressionAST) body;
        
        // set type of construct
        this.declaredType = type;
        
        // set location
        this.location = location;
	}

	@Override
	public FileLocation getLocation() {
		return location;
	}

	@Override
	public <S, T> T acceptVisitor(TypedASTVisitor<S, T> visitor, S state) {
		return visitor.visit(state, this);
	}

	@Override
	public String getName() {
		return name;
	}

    @Override
    public DeclType genILType(GenContext ctx) {
        ValueType vt = getILValueType(ctx);
        return new ValDeclType(getName(), vt);
    }

    private ValueType getILValueType(GenContext ctx) {
        /* this method does not work properly if called when the variable being
         * declared has already been added to ctx.  We solve this problem by
         * caching the value resulting from the first time this method is
         * invoked on this object */
        if (cachedValueType != null) {
            return cachedValueType;
        }
        ValueType vt;
        if (declaredType != null) {
            // convert the declared type if there is one
            vt = declaredType.getILType(ctx);
        } else {

            final Type type = this.binding.getType();
            if (type != null) {

                // then there is no proper R-value
                //if(definition == null) {
                vt = type.getILType(ctx);
            } else {
                // convert the declaration and typecheck it
                vt = body.generateIL(ctx, null, null).typeCheck(ctx, null);
            }
        }
        cachedValueType = vt;
        return vt;
    }

    @Override
    public wyvern.target.corewyvernIL.decl.Declaration generateDecl(GenContext ctx, GenContext thisContext) {

        ValueType expectedType = getILValueType(thisContext);
        /* uses ctx for generating the definition, as the selfName is not in scope */
        return new wyvern.target.corewyvernIL.decl.RecConstructDeclaration(getName(), expectedType, body.generateIL(ctx, expectedType, null), location);
    }

	@Override
	public wyvern.target.corewyvernIL.decl.Declaration topLevelGen(GenContext ctx, List<TypedModuleSpec> dependencies) {
		return generateDecl(ctx, ctx);
	}
}
