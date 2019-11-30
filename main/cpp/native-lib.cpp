#include <jni.h>
#include <string>
#include "foo.h"
#include <stdio.h>

int32_t foo (int32_t a, int32_t b) {

    int32_t g=a+b;

    return g;
}
extern "C" JNIEXPORT jstring JNICALL
Java_com_pokorsky_max_ss_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
extern "C" JNIEXPORT jint JNICALL
Java_com_pokorsky_max_ss_MainActivity_add(
        JNIEnv *env,
        jobject pObj,
        jint a,
        jint b) {
    //string jstr;

    int32_t n=foo(a,b);


    return n;
}
extern "C" JNIEXPORT jint JNICALL
Java_com_pokorsky_max_ss_SecondActivity_add(
        JNIEnv *env,
        jobject pObj,
        jint a,
        jint b

) {
    //string jstr;


    int32_t n=foo(a,b);


    return n;
}