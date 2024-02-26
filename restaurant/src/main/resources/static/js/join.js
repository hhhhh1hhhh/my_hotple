$(document).ready(function () {
    $('#check-duplicate').click(function (e) { // 이벤트 핸들러 설정
        e.preventDefault(); // 기본 동작 중단
        var username = $('#username').val(); // '#username' 입력 필드 값을 가져옴

        // AJAX 요청 보냄
        $.ajax({
            url: '/check_duplicate', // 요청을 보낼 URL
            data: { username: username }, // 서버에 보낼 데이터
            type: 'POST', // 요청 방식
            success: function (response) {
                // 요청이 성공하면 응답 메시지 표시
                alert(response.message);
            },
            error: function (error) {
                // 요청이 실패하면 오류 정보 콘솔 출력
                console.log(error);
            },
        });
    });

    $(document).ready(function () {
        $('#nickname').val(''); // 이름 입력 필드 초기화
        $('#username').val(''); // 이메일 입력 필드 초기화


        $(document).ready(function () {
            $('#nickname').on('input', function () {
                var input = $(this);
                var re = /^[가-힣a-zA-Z]{1,50}$/;
                var is_name = re.test(input.val());
                if (!is_name) {
                    $('#nicknameMessage').html('이름: 한글, 영문 대/소문자를 사용해 주세요. (특수기호, 공백 사용 불가)').css('color', 'red');
                } else {
                    $('#nicknameMessage').html('');
                }
            });

            $('#username').on('input', function () {
                const username = $('#username').val();
                const re = /^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$/;
                const is_username = re.test(username);

                if (username == '') {
                    $('#usernameMessage').html('이메일: 필수 입력정보입니다.').css('color', 'red');
                } else if (!is_username) {
                    $('#usernameMessage').html('잘못된 이메일입니다.').css('color', 'red');
                } else {
                    $('#usernameMessage').html('');
                    $.post('/check_duplicate', { username: $('#username').val() }, function (data) {
                        $('#usernameMessage')
                            .html(data.message)
                            .css('color', data.success ? 'green' : 'red');
                        $('#username').data('valid', data.success);
                    });
                }
            });

            $('#check-duplicate').on('click', function (e) {
                e.preventDefault(); // 기본 동작 중지

                $.post('/check_duplicate', { username: $('#username').val() }, function (data) {
                    $('#usernameMessage')
                        .html(data.message)
                        .css('color', data.success ? 'green' : 'red');
                    $('#username').data('valid', data.success);
                });
            });

            $('#password').on('input', function () {
                var input = $(this);
                var re = /^[A-Za-z\d@$!%*?&\-_#]{8,16}$/;
                var is_password = re.test(input.val());
                if (!is_password) {
                    $('#passwordMessage')
                        .html('비밀번호: 8~16자의 영문 대/소문자, 숫자, 특수문자(@,$,!,%,*,?,&,-,_,#)만 사용해 주세요. 한글과 공백은 사용할 수 없습니다.')
                        .css('color', 'red');
                } else {
                    $('#passwordMessage').html('');
                }
            });

            $('#togglePassword').on('click', function () {
                if ($('#password').attr('type') === 'password') {
                    $('#password').attr('type', 'text');
                    $('#togglePassword').text('비밀번호 숨기기');
                } else {
                    $('#password').attr('type', 'password');
                    $('#togglePassword').text('비밀번호 표시');
                }
            });

            $('#confirm_password').on('keyup', function () {
                if ($('#password').val() == $('#confirm_password').val()) {
                    $('#message').html('비밀번호가 일치합니다.').css('color', 'green');
                } else {
                    $('#message').html('비밀번호가 일치하지 않습니다.').css('color', 'red');
                }
            });

            $('form').on('submit', function (e) {
                if ($('#nickname').val() == '') {
                    e.preventDefault(); // 폼 제출 막기
                    $('#nicknameMessage').html('이름: 필수 입력정보입니다.').css('color', 'red');
                }
                if ($('#username').val() == '') {
                    e.preventDefault(); // 폼 제출 막기
                    $('#usernameMessage').html('이메일: 필수 입력정보입니다.').css('color', 'red');
                }
                if ($('#password').val() == '') {
                    e.preventDefault(); // 폼 제출 막기
                    $('#passwordMessage').html('비밀번호: 필수 입력정보입니다.').css('color', 'red');
                }
                if ($('#confirm_password').val() == '') {
                    e.preventDefault(); // 폼 제출 막기
                    $('#message').html('비밀번호 확인: 필수 입력정보입니다.').css('color', 'red');
                }
            });

            $('form').on('submit', function (e) {
                var nameRe = /^[가-힣a-zA-Z]{1,50}$/;
                var emailRe = /^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$/;
                var passwordRe = /^[A-Za-z\d@$!%*?&\-_#]{8,16}$/;

                var isNicknameValid = nameRe.test($('#nickname').val());
                var isUsernameValid = emailRe.test($('#username').val());
                var isPasswordValid = passwordRe.test($('#password').val());

                if (!isNicknameValid) {
                    e.preventDefault();
                    $('#nicknameMessage').html('이름: 한글, 영문 대/소문자를 사용해 주세요. (특수기호, 공백 사용 불가)').css('color', 'red');
                }

                if (!isUsernameValid) {
                    e.preventDefault();
                    $('#usernameMessage').html('잘못된 이메일입니다.').css('color', 'red');
                }

                if (!isPasswordValid) {
                    e.preventDefault();
                    $('#passwordMessage')
                        .html('비밀번호: 8~16자의 영문 대/소문자, 숫자, 특수문자(@,$,!,%,*,?,&,-,_,#)만 사용해 주세요. 한글과 공백은 사용할 수 없습니다.')
                        .css('color', 'red');
                }

                // 비밀번호 확인 필드가 비밀번호 필드와 일치하는지 확인
                if ($('#password').val() !== $('#confirm_password').val()) {
                    e.preventDefault();
                    $('#message').html('비밀번호가 일치하지 않습니다.').css('color', 'red');
                }

                // if (!$('#username').data('valid')) {
                //     e.preventDefault(); // 폼 제출 막기
                //     $('#usernameMessage').html('사용할 수 없는 이메일입니다.').css('color', 'red');
                // }

                if (isNicknameValid && isPasswordValid && isUsernameValid && ($('#password').val() === $('#confirm_password').val())) {
                    alert('회원가입이 완료되었습니다');
                }


            });


        });
    });
});
