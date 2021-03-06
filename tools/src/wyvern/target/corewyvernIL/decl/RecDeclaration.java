package wyvern.target.corewyvernIL.decl;

import java.util.Set;

import wyvern.target.corewyvernIL.astvisitor.ASTVisitor;
import wyvern.target.corewyvernIL.decltype.DeclType;
import wyvern.target.corewyvernIL.support.TypeContext;
import wyvern.tools.typedAST.interfaces.ExpressionAST;
import wyvern.tools.typedAST.interfaces.TypedAST;

public class RecDeclaration extends NamedDeclaration {
	private ExpressionAST body;
	
	public RecDeclaration(TypedAST body) {
		super(null, null);
		System.out.println();
		System.out.println("RecDeclaration (decl) Called.");
		System.out.println("	RecDeclaration Body: " + body); // debugger
		System.out.println();
		this.body = (ExpressionAST) body;
	}	

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
