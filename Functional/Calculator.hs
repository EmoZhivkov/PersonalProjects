import Data.Char

data Token
    = PlusTok
    | TimesTok
    | OpenTok
    | CloseTok
    | IntTok Int
    deriving (Show)
-----------------------
lexer :: String -> [Token]
lexer []              = []
lexer ('+' : restStr) = PlusTok  : lexer restStr
lexer ('*' : restStr) = TimesTok : lexer restStr
lexer ('(' : restStr) = OpenTok    : lexer restStr
lexer (')' : restStr) = CloseTok   : lexer restStr
lexer (chr : restStr) | isSpace chr = lexer restStr
lexer str@(chr : _)
  | isDigit chr
  = IntTok (stringToInt digitStr) : lexer restStr
  where
     (digitStr, restStr) = break (not . isDigit) str
     stringToInt :: String -> Int
     stringToInt = foldl (\acc chr -> 10 * acc + digitToInt chr) 0
lexer (chr : restString)
  = error ("lexer: unexpected character: '" ++ (show chr) ++ "'")
-------------------
data Expr
  = IntLit Int
  | Add    Expr Expr
  | Mult   Expr Expr
  deriving Show
--------------------
parseInt :: [Token] -> Maybe (Expr, [Token])
parseInt (IntTok n : restTokens)
  = Just (IntLit n, restTokens)
parseInt tokens
  = Nothing

parseProdOrInt :: [Token] -> Maybe (Expr, [Token])
parseProdOrInt tokens
  = case parseInt tokens of
      Just (expr1, (TimesTok : restTokens1)) ->
          case parseProdOrInt restTokens1 of
            Just (expr2, restTokens2) -> Just (Mult expr1 expr2, restTokens2)
            Nothing                   -> Nothing
      result -> result

parseSumOrProdOrInt :: [Token] -> Maybe (Expr, [Token])
parseSumOrProdOrInt tokens
  = case parseProdOrInt tokens of
      Just (expr1, (PlusTok : restTokens1)) ->
          case parseProdOrInt restTokens1 of
            Just (expr2, restTokens2) -> Just (Add expr1 expr2, restTokens2)
            Nothing                   -> Nothing
      result -> result

parseIntOrParenExpr :: [Token] -> Maybe (Expr, [Token])
parseIntOrParenExpr (IntTok n : restTokens)
  = Just (IntLit n,   restTokens)
parseIntOrParenExpr (OpenTok : restTokens1)
  = case parseSumOrProdOrIntOrParenExpr restTokens1 of
       Just (expr, (CloseTok : restTokens2)) -> Just (expr, restTokens2)
       Just _  -> Nothing
       Nothing -> Nothing
parseIntOrParenExpr tokens
  = Nothing

parseProdOrIntOrParenExpr :: [Token] -> Maybe (Expr, [Token])
parseProdOrIntOrParenExpr tokens
  = case parseIntOrParenExpr tokens of
      Just (expr1, (TimesTok : restTokens1)) ->
          case parseProdOrIntOrParenExpr restTokens1 of
            Just (expr2, restTokens2) -> Just (Mult expr1 expr2, restTokens2)
            Nothing                   -> Nothing
      result -> result

parseSumOrProdOrIntOrParenExpr :: [Token] -> Maybe (Expr, [Token])
parseSumOrProdOrIntOrParenExpr tokens
  = case parseProdOrIntOrParenExpr tokens of
      Just (expr1, (PlusTok : restTokens1)) ->
          case parseSumOrProdOrIntOrParenExpr restTokens1 of
            Just (expr2, restTokens2) -> Just (Add expr1 expr2, restTokens2)
            Nothing                   -> Nothing
      result -> result

parse :: [Token] -> Expr
parse tokens =
  case parseSumOrProdOrIntOrParenExpr tokens of
    Just (expr, []) -> expr
    _               -> error "Could not parse input"
------------------------
eval :: Expr -> Int
eval (IntLit n) = n
eval (Add expr1 expr2)
  = eval expr1 + eval expr2
eval (Mult expr1 expr2)
  = eval expr1 * eval expr2




