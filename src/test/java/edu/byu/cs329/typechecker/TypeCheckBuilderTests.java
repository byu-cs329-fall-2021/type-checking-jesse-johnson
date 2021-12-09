package edu.byu.cs329.typechecker;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import edu.byu.cs329.utils.JavaSourceUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.eclipse.jdt.core.dom.ASTNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.opentest4j.AssertionFailedError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DisplayName("Tests for TypeCheckerBuilder")
public class TypeCheckBuilderTests {
  static final Logger log = LoggerFactory.getLogger(TypeCheckBuilderTests.class);

  private boolean getTypeChecker(final String fileName, List<DynamicNode> tests) {
    ASTNode compilationUnit = JavaSourceUtils.getAstNodeFor(this, fileName);
    SymbolTableBuilder symbolTableBuilder = new SymbolTableBuilder();
    ISymbolTable symbolTable = symbolTableBuilder.getSymbolTable(compilationUnit);
    TypeCheckBuilder typeCheckerBuilder = new TypeCheckBuilder();
    return typeCheckerBuilder.getTypeChecker(symbolTable, compilationUnit, tests);
  }
 
  @TestFactory
  @DisplayName("Should prove type safe when given empty class")
  Stream<DynamicNode> should_proveTypeSafe_when_givenEmptyClass() {
    String fileName = "typeChecker/should_proveTypeSafe_when_givenEmptyClass.java";
    List<DynamicNode> tests = new ArrayList<>();
    boolean isTypeSafe = getTypeChecker(fileName, tests);
    DynamicTest test = DynamicTest.dynamicTest("isTypeSafe", () -> assertTrue(isTypeSafe));
    tests.add((DynamicNode)test);
    return tests.stream();
  }

  @TestFactory
  @DisplayName("Should prove type safe when given empty method")
  Stream<DynamicNode> should_proveTypeSafe_when_givenEmptyMethod() {
    String fileName = "typeChecker/should_proveTypeSafe_when_givenEmptyMethod.java";
    List<DynamicNode> tests = new ArrayList<>();
    boolean isTypeSafe = getTypeChecker(fileName, tests);
    DynamicTest test = DynamicTest.dynamicTest("isTypeSafe", () -> assertTrue(isTypeSafe));
    tests.add((DynamicNode)test);
    return tests.stream();
  }

  @TestFactory
  @DisplayName("Should prove type safe when given empty block")
  Stream<DynamicNode> should_proveTypeSafe_when_givenEmptyBlock() {
    String fileName = "typeChecker/should_proveTypeSafe_when_givenEmptyBlock.java";
    List<DynamicNode> tests = new ArrayList<>();
    boolean isTypeSafe = getTypeChecker(fileName, tests);
    DynamicTest test = DynamicTest.dynamicTest("isTypeSafe", () -> assertTrue(isTypeSafe));
    tests.add((DynamicNode)test);
    return tests.stream();
  }

  @TestFactory
  @DisplayName("Should prove type safe when given variable declarations no inits")
  Stream<DynamicNode> should_proveTypeSafe_when_givenVariableDeclrationsNoInits() {
    String fileName = "typeChecker/should_proveTypeSafe_when_givenVariableDeclrationsNoInits.java";
    List<DynamicNode> tests = new ArrayList<>();
    boolean isTypeSafe = getTypeChecker(fileName, tests);
    DynamicTest test = DynamicTest.dynamicTest("isTypeSafe", () -> assertTrue(isTypeSafe));
    tests.add((DynamicNode)test);
    return tests.stream();
  }

  @TestFactory
  @DisplayName("Should prove type safe when given variable declarations with compatible inits")
  Stream<DynamicNode> should_proveTypeSafe_when_givenVariableDeclrationsWithCompatibleInits() {
    String fileName = "typeChecker/should_proveTypeSafe_when_givenVariableDeclrationsWithCompatibleInits.java";
    List<DynamicNode> tests = new ArrayList<>();
    boolean isTypeSafe = getTypeChecker(fileName, tests);
    DynamicTest test = DynamicTest.dynamicTest("isTypeSafe", () -> assertTrue(isTypeSafe));
    tests.add((DynamicNode)test);
    return tests.stream();
  }

  @TestFactory
  @DisplayName("Should not prove type safe when given bad inits")
  Stream<DynamicNode> should_NotProveTypeSafe_when_givenBadInits() {
    String fileName = "typeChecker/should_NotProveTypeSafe_when_givenBadInits.java";
    List<DynamicNode> tests = new ArrayList<>();
    boolean isTypeSafe = getTypeChecker(fileName, tests);

    // Toggle as desired
    // 
    // Option 1: mvn exec:java shows the details of the typeproof for visual inspection
    // return tests.stream();
    //
    // Option 2: test only isNotTypeSafe and show no details
    DynamicTest test = DynamicTest.dynamicTest("isNotTypeSafe", () -> assertFalse(isTypeSafe));
    return Arrays.asList((DynamicNode)test).stream();
  }
  @TestFactory
  @DisplayName("Should prove type safe for prefix expression")
  Stream<DynamicNode> should_ProveTypeSafe_for_PrefixExpression() {
    String fileName = "typeChecker/prefix.java";
    List<DynamicNode> tests = new ArrayList<>();
    boolean isTypeSafe = getTypeChecker(fileName, tests);
    DynamicTest test = DynamicTest.dynamicTest("isTypeSafe", () -> assertTrue(isTypeSafe));
    tests.add((DynamicNode)test);
    return tests.stream();
  }

  @TestFactory
  @DisplayName("Should prove type safe for infix expression as integer")
  Stream<DynamicNode> should_ProveTypeSafe_for_InfixExpression_Int() {
    String fileName = "typeChecker/infix_int.java";
    List<DynamicNode> tests = new ArrayList<>();
    boolean isTypeSafe = getTypeChecker(fileName, tests);
    DynamicTest test = DynamicTest.dynamicTest("isTypeSafe", () -> assertTrue(isTypeSafe));
    tests.add((DynamicNode)test);
    return tests.stream();
  }
  @TestFactory
  @DisplayName("Should prove type safe for infix expression as boolean")
  Stream<DynamicNode> should_ProveTypeSafe_for_InfixExpression_Boolean() {
    String fileName = "typeChecker/infix_bool.java";
    List<DynamicNode> tests = new ArrayList<>();
    boolean isTypeSafe = getTypeChecker(fileName, tests);
    DynamicTest test = DynamicTest.dynamicTest("isTypeSafe", () -> assertTrue(isTypeSafe));
    tests.add((DynamicNode)test);
    return tests.stream();
  }
  @TestFactory
  @DisplayName("Should not prove type safe for infix expression")
  Stream<DynamicNode> should_NotProveTypeSafe_for_InfixExpression_Broken() {
    String fileName = "typeChecker/infix_broken.java";
    List<DynamicNode> tests = new ArrayList<>();
    boolean isTypeSafe = getTypeChecker(fileName, tests);
    DynamicTest test = DynamicTest.dynamicTest("isNotTypeSafe", () -> assertFalse(isTypeSafe));
    tests.add((DynamicNode)test);
    return tests.stream();
  }
  @TestFactory
  @DisplayName("Should prove type safe for return statement")
  Stream<DynamicNode> should_ProveTypeSafe_for_ReturnStatement() {
    String fileName = "typeChecker/return_statement.java";
    List<DynamicNode> tests = new ArrayList<>();
    boolean isTypeSafe = getTypeChecker(fileName, tests);
    DynamicTest test = DynamicTest.dynamicTest("isTypeSafe", () -> assertTrue(isTypeSafe));
    tests.add((DynamicNode)test);
    return tests.stream();
  }
  @TestFactory
  @DisplayName("Should not prove type safe for return statement when no expression to return")
  Stream<DynamicNode> should_NotProveTypeSafe_for_ReturnStatement_NullExpression() {
    String fileName = "typeChecker/return_null.java";
    List<DynamicNode> tests = new ArrayList<>();
    boolean isTypeSafe = getTypeChecker(fileName, tests);
    DynamicTest test = DynamicTest.dynamicTest("isNotTypeSafe", () -> assertFalse(isTypeSafe));
    tests.add((DynamicNode)test);
    return tests.stream();
  }
  @TestFactory
  @DisplayName("Should not prove type safe for return statement when not void")
  Stream<DynamicNode> should_NotProveTypeSafe_for_ReturnStatement_NotVoid() {
    String fileName = "typeChecker/return_notVoid.java";
    List<DynamicNode> tests = new ArrayList<>();
    boolean isTypeSafe = getTypeChecker(fileName, tests);
    DynamicTest test = DynamicTest.dynamicTest("isNotTypeSafe", () -> assertFalse(isTypeSafe));
    tests.add((DynamicNode)test);
    return tests.stream();
  }
  @TestFactory
  @DisplayName("Should prove type safe for expression statement as assignment")
  Stream<DynamicNode> should_ProveTypeSafe_for_ExpressionStatement_Assignment() {
    String fileName = "typeChecker/expression_assignment.java";
    List<DynamicNode> tests = new ArrayList<>();
    boolean isTypeSafe = getTypeChecker(fileName, tests);
    DynamicTest test = DynamicTest.dynamicTest("isTypeSafe", () -> assertTrue(isTypeSafe));
    tests.add((DynamicNode)test);
    return tests.stream();
  }
  @TestFactory
  @DisplayName("Should not prove type safe for expression statement when not assignment or method invocation")
  Stream<DynamicNode> should_NotProveTypeSafe_for_ExpressionStatement_Broken() {
    String fileName = "typeChecker/expression_broken.java";
    List<DynamicNode> tests = new ArrayList<>();
    boolean isTypeSafe = getTypeChecker(fileName, tests);
    DynamicTest test = DynamicTest.dynamicTest("isNotTypeSafe", () -> assertFalse(isTypeSafe));
    tests.add((DynamicNode)test);
    return tests.stream();
  }
  @TestFactory
  @DisplayName("Should prove type safe for if statement")
  Stream<DynamicNode> should_ProveTypeSafe_for_IfStatement() {
    String fileName = "typeChecker/if_statement.java";
    List<DynamicNode> tests = new ArrayList<>();
    boolean isTypeSafe = getTypeChecker(fileName, tests);
    DynamicTest test = DynamicTest.dynamicTest("isTypeSafe", () -> assertTrue(isTypeSafe));
    tests.add((DynamicNode)test);
    return tests.stream();
  }
  @TestFactory
  @DisplayName("Should prove not type safe for if statement not as boolean")
  Stream<DynamicNode> should_NotProveTypeSafe_for_IfStatement_Broken() {
    String fileName = "typeChecker/if_broken.java";
    List<DynamicNode> tests = new ArrayList<>();
    boolean isTypeSafe = getTypeChecker(fileName, tests);
    DynamicTest test = DynamicTest.dynamicTest("isNotTypeSafe", () -> assertFalse(isTypeSafe));
    tests.add((DynamicNode)test);
    return tests.stream();
  }
  @TestFactory
  @DisplayName("Should prove type safe for while statement")
  Stream<DynamicNode> should_ProveTypeSafe_for_WhileStatement() {
    String fileName = "typeChecker/while_statement.java";
    List<DynamicNode> tests = new ArrayList<>();
    boolean isTypeSafe = getTypeChecker(fileName, tests);
    DynamicTest test = DynamicTest.dynamicTest("isTypeSafe", () -> assertTrue(isTypeSafe));
    tests.add((DynamicNode)test);
    return tests.stream();
  }
  @TestFactory
  @DisplayName("Should not prove type safe for while statement not as boolean")
  Stream<DynamicNode> should_NotProveTypeSafe_for_WhileStatement_Broken() {
    String fileName = "";
    List<DynamicNode> tests = new ArrayList<>();
    boolean isTypeSafe = getTypeChecker(fileName, tests);
    DynamicTest test = DynamicTest.dynamicTest("isNotTypeSafe", () -> assertFalse(isTypeSafe));
    tests.add((DynamicNode)test);
    return tests.stream();
  }
  
  @Test
  @DisplayName("Test for prefix test")
  void prefix(){
    String fileName = "typeChecker/prefix.java";
    List<DynamicNode> tests = new ArrayList<>();
    boolean isTypeSafe = getTypeChecker(fileName, tests);
    Assertions.assertTrue(isTypeSafe);
    Iterator<DynamicNode> iter = tests.iterator();
    DynamicNode n = iter.next();
    Assertions.assertTrue(n instanceof DynamicTest);
    DynamicTest t = (DynamicTest) n;
    Assertions.assertDoesNotThrow(t.getExecutable());
    n = iter.next();
    Assertions.assertTrue(n instanceof DynamicTest);
    t = (DynamicTest) n;
    Assertions.assertThrows(AssertionFailedError.class, t.getExecutable());
  }
  @Test
  @DisplayName("Test for integer infix test")
  void integer_infix(){
    String fileName = "typeChecker/infix_int.java";
    List<DynamicNode> tests = new ArrayList<>();
    boolean isTypeSafe = getTypeChecker(fileName, tests);
    Assertions.assertTrue(isTypeSafe);
    Iterator<DynamicNode> iter = tests.iterator();
    DynamicNode n = iter.next();
    Assertions.assertTrue(n instanceof DynamicTest);
    DynamicTest t = (DynamicTest) n;
    Assertions.assertDoesNotThrow(t.getExecutable());
    n = iter.next();
    Assertions.assertTrue(n instanceof DynamicTest);
    t = (DynamicTest) n;
    Assertions.assertThrows(AssertionFailedError.class, t.getExecutable());
  }
  @Test
  @DisplayName("Test for boolean infix test")
  void boolean_infix(){
    String fileName = "typeChecker/infix_bool.java";
    List<DynamicNode> tests = new ArrayList<>();
    boolean isTypeSafe = getTypeChecker(fileName, tests);
    Assertions.assertTrue(isTypeSafe);
    Iterator<DynamicNode> iter = tests.iterator();
    DynamicNode n = iter.next();
    Assertions.assertTrue(n instanceof DynamicTest);
    DynamicTest t = (DynamicTest) n;
    Assertions.assertDoesNotThrow(t.getExecutable());
    n = iter.next();
    Assertions.assertTrue(n instanceof DynamicTest);
    t = (DynamicTest) n;
    Assertions.assertThrows(AssertionFailedError.class, t.getExecutable());
  }
  @Test
  @DisplayName("Test for failed infix test")
  void failed_infix(){
    String fileName = "typeChecker/infix_broken.java";
    List<DynamicNode> tests = new ArrayList<>();
    boolean isTypeSafe = getTypeChecker(fileName, tests);
    Assertions.assertFalse(isTypeSafe);
    Iterator<DynamicNode> iter = tests.iterator();
    DynamicNode n = iter.next();
    Assertions.assertTrue(n instanceof DynamicTest);
    DynamicTest t = (DynamicTest) n;
    Assertions.assertDoesNotThrow(t.getExecutable());
    n = iter.next();
    Assertions.assertTrue(n instanceof DynamicTest);
    t = (DynamicTest) n;
    Assertions.assertThrows(AssertionFailedError.class, t.getExecutable());
  }
  @Test
  @DisplayName("Test for return sucess test")
  void return_success(){
    String fileName = "typeChecker/return_statement.java";
    List<DynamicNode> tests = new ArrayList<>();
    boolean isTypeSafe = getTypeChecker(fileName, tests);
    Assertions.assertFalse(isTypeSafe);
    Iterator<DynamicNode> iter = tests.iterator();
    DynamicNode n = iter.next();
    Assertions.assertTrue(n instanceof DynamicTest);
    DynamicTest t = (DynamicTest) n;
    Assertions.assertDoesNotThrow(t.getExecutable());
    n = iter.next();
    Assertions.assertTrue(n instanceof DynamicTest);
    t = (DynamicTest) n;
    Assertions.assertThrows(AssertionFailedError.class, t.getExecutable());
  }
  @Test
  @DisplayName("Test for return not void test")
  void return_not_void(){
    String fileName = "typeChecker/return_notVoid.java";
    List<DynamicNode> tests = new ArrayList<>();
    boolean isTypeSafe = getTypeChecker(fileName, tests);
    Assertions.assertTrue(isTypeSafe);
    Iterator<DynamicNode> iter = tests.iterator();
    DynamicNode n = iter.next();
    Assertions.assertTrue(n instanceof DynamicTest);
    DynamicTest t = (DynamicTest) n;
    Assertions.assertDoesNotThrow(t.getExecutable());
    n = iter.next();
    Assertions.assertTrue(n instanceof DynamicTest);
    t = (DynamicTest) n;
    Assertions.assertThrows(AssertionFailedError.class, t.getExecutable());
  }
  @Test
  @DisplayName("Test for return null test")
  void return_null(){
    String fileName = "typeChecker/return_null.java";
    List<DynamicNode> tests = new ArrayList<>();
    boolean isTypeSafe = getTypeChecker(fileName, tests);
    Assertions.assertFalse(isTypeSafe);
    Iterator<DynamicNode> iter = tests.iterator();
    DynamicNode n = iter.next();
    Assertions.assertTrue(n instanceof DynamicTest);
    DynamicTest t = (DynamicTest) n;
    Assertions.assertDoesNotThrow(t.getExecutable());
    n = iter.next();
    Assertions.assertTrue(n instanceof DynamicTest);
    t = (DynamicTest) n;
    Assertions.assertThrows(AssertionFailedError.class, t.getExecutable());
  }
  @Test
  @DisplayName("Test for expression assignment test")
  void expression_assignment(){
    String fileName = "typeChecker/expression_assignment.java";
    List<DynamicNode> tests = new ArrayList<>();
    boolean isTypeSafe = getTypeChecker(fileName, tests);
    Assertions.assertTrue(isTypeSafe);
    Iterator<DynamicNode> iter = tests.iterator();
    DynamicNode n = iter.next();
    Assertions.assertTrue(n instanceof DynamicTest);
    DynamicTest t = (DynamicTest) n;
    Assertions.assertDoesNotThrow(t.getExecutable());
    n = iter.next();
    Assertions.assertTrue(n instanceof DynamicTest);
    t = (DynamicTest) n;
    Assertions.assertThrows(AssertionFailedError.class, t.getExecutable());
  }
  @Test
  @DisplayName("Test for expression fail test")
  void expression_fail(){
    String fileName = "typeChecker/expression_broken.java";
    List<DynamicNode> tests = new ArrayList<>();
    boolean isTypeSafe = getTypeChecker(fileName, tests);
    Assertions.assertFalse(isTypeSafe);
    Iterator<DynamicNode> iter = tests.iterator();
    DynamicNode n = iter.next();
    Assertions.assertTrue(n instanceof DynamicTest);
    DynamicTest t = (DynamicTest) n;
    Assertions.assertDoesNotThrow(t.getExecutable());
    n = iter.next();
    Assertions.assertTrue(n instanceof DynamicTest);
    t = (DynamicTest) n;
    Assertions.assertThrows(AssertionFailedError.class, t.getExecutable());
  }
  @Test
  @DisplayName("Test for if success test")
  void if_success(){
    String fileName = "typeChecker/if_statement.java";
    List<DynamicNode> tests = new ArrayList<>();
    boolean isTypeSafe = getTypeChecker(fileName, tests);
    Assertions.assertTrue(isTypeSafe);
    Iterator<DynamicNode> iter = tests.iterator();
    DynamicNode n = iter.next();
    Assertions.assertTrue(n instanceof DynamicTest);
    DynamicTest t = (DynamicTest) n;
    Assertions.assertDoesNotThrow(t.getExecutable());
    n = iter.next();
    Assertions.assertTrue(n instanceof DynamicTest);
    t = (DynamicTest) n;
    Assertions.assertThrows(AssertionFailedError.class, t.getExecutable());
  }
  @Test
  @DisplayName("Test for if fail test")
  void if_fail(){
    String fileName = "typeChecker/if_broken.java";
    List<DynamicNode> tests = new ArrayList<>();
    boolean isTypeSafe = getTypeChecker(fileName, tests);
    Assertions.assertFalse(isTypeSafe);
    Iterator<DynamicNode> iter = tests.iterator();
    DynamicNode n = iter.next();
    Assertions.assertTrue(n instanceof DynamicTest);
    DynamicTest t = (DynamicTest) n;
    Assertions.assertDoesNotThrow(t.getExecutable());
    n = iter.next();
    Assertions.assertTrue(n instanceof DynamicTest);
    t = (DynamicTest) n;
    Assertions.assertThrows(AssertionFailedError.class, t.getExecutable());
  }
  @Test
  @DisplayName("Test for while success test")
  void while_success(){
    String fileName = "typeChecker/while_statement.java";
    List<DynamicNode> tests = new ArrayList<>();
    boolean isTypeSafe = getTypeChecker(fileName, tests);
    Assertions.assertTrue(isTypeSafe);
    Iterator<DynamicNode> iter = tests.iterator();
    DynamicNode n = iter.next();
    Assertions.assertTrue(n instanceof DynamicTest);
    DynamicTest t = (DynamicTest) n;
    Assertions.assertDoesNotThrow(t.getExecutable());
    n = iter.next();
    Assertions.assertTrue(n instanceof DynamicTest);
    t = (DynamicTest) n;
    Assertions.assertThrows(AssertionFailedError.class, t.getExecutable());
  }
  @Test
  @DisplayName("Test for while fail test")
  void while_fail(){
    String fileName = "typeChecker/while_broken.java";
    List<DynamicNode> tests = new ArrayList<>();
    boolean isTypeSafe = getTypeChecker(fileName, tests);
    Assertions.assertFalse(isTypeSafe);
    Iterator<DynamicNode> iter = tests.iterator();
    DynamicNode n = iter.next();
    Assertions.assertTrue(n instanceof DynamicTest);
    DynamicTest t = (DynamicTest) n;
    Assertions.assertDoesNotThrow(t.getExecutable());
    n = iter.next();
    Assertions.assertTrue(n instanceof DynamicTest);
    t = (DynamicTest) n;
    Assertions.assertThrows(AssertionFailedError.class, t.getExecutable());
  }
}