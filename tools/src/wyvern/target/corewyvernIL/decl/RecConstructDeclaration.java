package wyvern.target.corewyvernIL.decl;

import java.util.Set;

import wyvern.target.corewyvernIL.astvisitor.ASTVisitor;
import wyvern.target.corewyvernIL.decltype.DeclType;
import wyvern.target.corewyvernIL.expression.IExpr;
import wyvern.target.corewyvernIL.support.TypeContext;
import wyvern.target.corewyvernIL.type.ValueType;
import wyvern.tools.errors.FileLocation;
import wyvern.tools.typedAST.core.binding.NameBinding;
import wyvern.tools.typedAST.core.binding.NameBindingImpl;
import wyvern.tools.typedAST.interfaces.ExpressionAST;
import wyvern.tools.typedAST.interfaces.TypedAST;
import wyvern.tools.types.Type;

public class RecConstructDeclaration extends NamedDeclaration {
	
    private ValueType type;
    
    
    
	private String name;
	private ExpressionAST body;
    private NameBinding binding;
	private Type declaredType;
    private FileLocation location = FileLocation.UNKNOWN;
    private ValueType cachedValueType;
    	
    public RecConstructDeclaration(String fieldName, ValueType type, IExpr iExpr, FileLocation loc) {
        super(fieldName, loc);
        this.type = type;
    }
   /* 
	public RecConstructDeclaration(String name, Type type, TypedAST body, FileLocation location) {
			//super(name, location);
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
*/
    
	@Override
	public <S, T> T acceptVisitor(ASTVisitor<S, T> visitor, S state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeclType getDeclType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeclType typeCheck(TypeContext ctx, TypeContext thisCtx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getFreeVariables() {
		// TODO Auto-generated method stub
		return null;
	}

}
