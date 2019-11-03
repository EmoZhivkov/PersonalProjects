#include <bits/stdc++.h>
using namespace std;
#define null NULL
#define mp make_pair
#define pb(a) push_back(a)
#define sz(a) ((int)(a).size())
#define all(a) a.begin() , a.end()
#define fi first
#define se second
#define relaxMin(a , b) (a) = min((a),(b))
#define relaxMax(a , b) (a) = max((a),(b))
#define SQR(a) ((a)*(a))
typedef vector<int> vi;
typedef pair<int,int> pii;
typedef long long ll;

const int BASE = 1E9;
const int BASE_LEN = 9;

struct BigInt {
  vi dig;

  BigInt() {}

  BigInt(const string& from) {
    for (int end = sz(from); end > 0; end -= BASE_LEN) {
      int start = max(0, end - BASE_LEN);
      dig.pb(0);
      for (int i = start; i < end; ++i)
        dig.back() = 10 * dig.back() + from[i] - '0';
    }
    RemoveLeadingZeros();
  }

  BigInt(ll from) {
    while (dig.empty() || from > 0) {
      dig.pb(from % BASE);
      from /= BASE;
    }
  }

  void RemoveLeadingZeros() {
    while (sz(dig) > 1 && dig.back() == 0)
      dig.pop_back();
  }

  string ToString() const {
    stringstream out;
    out << dig.back();
    for (int i = sz(dig) - 2; i >= 0; --i)
      out << setfill('0') << setw(BASE_LEN) << dig[i];
    return out.str();
  }

  bool operator==(const BigInt& w) const {
    return dig == w.dig;
  }

  bool operator<(const BigInt& w) const {
    if (sz(dig) != sz(w.dig)) return sz(dig) < sz(w.dig);
    for (int i = sz(dig) - 1; i >= 0; --i)
      if (dig[i] != w.dig[i]) return dig[i] < w.dig[i];
    return false;
  }

  void operator+=(const BigInt& w) {
    int carry = 0;
    for (int i = 0; i < max(sz(dig), sz(w.dig)) || carry; ++i) {
      if (i >= sz(dig)) dig.pb(0);
      dig[i] += carry + (i < sz(w.dig) ? w.dig[i] : 0);
      carry = (dig[i] >= BASE);
      if (carry) dig[i] -= BASE;
    }
    RemoveLeadingZeros();
  }

  BigInt operator+(const BigInt& w) const {
    BigInt res = *this;
    res += w;
    return res;
  }

  void operator-=(const BigInt& w) {
    int carry = 0;
    for (int i = 0; i < sz(dig); ++i) {
      dig[i] -= carry + (i < sz(w.dig) ? w.dig[i] : 0);
      carry = (dig[i] < 0);
      if (carry) dig[i] += BASE;
    }
    RemoveLeadingZeros();
  }

  BigInt operator-(const BigInt& w) const {
    BigInt res = *this;
    res -= w;
    return res;
  }

  BigInt operator*(const BigInt& w) const {
    BigInt res;
    res.dig.resize(sz(dig) + sz(w.dig));
    for (int i = 0; i < sz(dig); ++i) {
      int carry = 0;
      for (int j = 0; j < sz(w.dig) || carry; ++j) {
        ll tmp = res.dig[i + j] + carry;
        if (j < sz(w.dig)) tmp += w.dig[j] * 1LL * dig[i];
        carry = tmp / BASE;
        res.dig[i + j] = tmp % BASE;
      }
    }
    res.RemoveLeadingZeros();
    return res;
  }

  BigInt operator/(BigInt b) {
    BigInt a = *this;
    ll mult = BASE / (b.dig.back() + 1);
    a = a * mult;
    b = b * mult;
    BigInt res, val(0);
    res.dig.resize(sz(a.dig));
    for (int i = sz(a.dig) - 1; i >= 0; --i) {
      val = val * BASE + a.dig[i];
      ll first_digits = 0;
      if (sz(val.dig) >= sz(b.dig))
        first_digits += val.dig.back();
      if (sz(val.dig) > sz(b.dig))
        (first_digits *= BASE) += val.dig[sz(val.dig) - 2];
      int koef = first_digits / b.dig.back();
      while (val < b * koef) --koef;
      res.dig[i] = koef;
      val -= b * koef;
    }
    res.RemoveLeadingZeros();
    return res;
  }
};

int main() {
  return 0;
}
