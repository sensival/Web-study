
// 정규 표현식 리터럴, 실행결과는 문자열 a를 값으로 하는 배열을 리턴한다.
var pattern = /a/

//정규표현식 객체 생성자, 인자 'bcdef'에는 a가 없기 때문에 null을 리턴한다.
var pattern = new RegExp('a');

//exec
console.log(pattern.exec('abcdef')); // ["a"]
console.log(pattern.exec('bcdefg')); // null

//match
console.log('abcdef'.match(pattern)); // ["a"]
console.log('bcdefg'.match(pattern)); // null   

//replace
console.log('abcdef'.replace(pattern, 'A'));  // Abcdef

//i 옵션
var xi = /a/;
console.log("Abcde".match(xi)); // null
var oi = /a/i;
console.log("Abcde".match(oi)); // ["A"];

//g 옵션
var xg = /a/;
console.log("abcdea".match(xg)); //a
var og = /a/g;
console.log("abcdea".match(og));//[a,a]

// $ 
var pattern = /(\w+)\s(\w+)/;
var str = "coding everybody";
var result = str.replace(pattern, "$2, $1");
console.log(result);

// 
var urlPattern = /\b(?:https?):\/\/[a-z0-9-+&@#\/%?=~_|!:,.;]*/gim;
var content = '생활코딩 : http://opentutorials.org/course/1 입니다. 네이버 : http://naver.com 입니다. ';
var result = content.replace(urlPattern, function(url){
    return '<a href="'+url+'">'+url+'</a>';
});
console.log(result);